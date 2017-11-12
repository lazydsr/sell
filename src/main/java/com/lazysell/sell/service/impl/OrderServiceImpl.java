package com.lazysell.sell.service.impl;

import com.lazy.util.id.UtilUUId;
import com.lazy.util.time.UtilDateTime;
import com.lazysell.sell.converter.OrderMaster2OrderDTOConverter;
import com.lazysell.sell.dao.OrderDetailDao;
import com.lazysell.sell.dao.OrderMasterDao;
import com.lazysell.sell.dto.CartDTO;
import com.lazysell.sell.dto.OrderDTO;
import com.lazysell.sell.enums.OrderStatusEnum;
import com.lazysell.sell.enums.PayStatusEnum;
import com.lazysell.sell.enums.ResultEnum;
import com.lazysell.sell.exception.SellException;
import com.lazysell.sell.pojo.OrderDetail;
import com.lazysell.sell.pojo.OrderMaster;
import com.lazysell.sell.pojo.ProductInfo;
import com.lazysell.sell.service.OrderService;
import com.lazysell.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * OrderServiceImpl
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service.impl
 * Created by Lazy on 2017/11/11 20:30
 * Version: 0.1
 * Info: @TODO:...
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterDao masterDao;
    @Autowired
    private OrderDetailDao detailDao;
    @Autowired
    private ProductService productService;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = UtilUUId.getId();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1.查询商品--数量  价格
        for (OrderDetail detail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(detail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价
            orderAmount = orderAmount.add(productInfo.getProductPrice().multiply(new BigDecimal(detail.getProductQuantity())));
            //3.写入数据库  orderDetail
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(UtilUUId.getId());
            orderDetail.setOrderId(orderId);
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetail.setProductQuantity(detail.getProductQuantity());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductId(detail.getProductId());
            orderDetail.setProductName(productInfo.getProductName());
            detailDao.save(orderDetail);
        }
        //4.写入masterDetail
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setId(orderId);
        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        orderMaster.setBuyerOpenid(orderDTO.getBuyerOpenid());
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        orderMaster.setBuyerAmount(orderAmount);
        orderMaster.setBuyerAddress(orderDTO.getBuyerAddress());
        OrderMaster master = masterDao.save(orderMaster);

        //4.扣库存
        List<CartDTO> list = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(list);
        return findOne(master.getId());
    }

    @Override
    @Transactional
    @Deprecated
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = masterDao.findOne(orderId);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetails = detailDao.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetails)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO findOneV2(String openid, String orderId) {
        OrderMaster orderMaster = masterDao.findOne(orderId);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderMaster.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】:订单不属于该用户：openid={}，orderId={}", openid, orderId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        List<OrderDetail> orderDetails = detailDao.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetails)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;
    }


    @Override
    @Transactional
    public Page<OrderDTO> findList(String openid, Pageable pageable) {
        Page<OrderMaster> orderMasters = masterDao.findByBuyerOpenid(openid, pageable);

        return new PageImpl<OrderDTO>(OrderMaster2OrderDTOConverter.convert(orderMasters.getContent()), pageable, orderMasters.getTotalElements());

    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster = masterDao.findOne(orderDTO.getId());
        if (orderMaster == null) {
            log.error("[取消订单] 订单不存在，orderId:{}", orderDTO.getId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW_ORDER.getCode())) {
            log.error("[取消订单] 订单状态不正确，orderid：{},orderStatus:{},datetime:{}", orderMaster.getId(), orderMaster.getOrderStatus(), UtilDateTime.getCurrDateTime());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        OrderMaster master = masterDao.save(orderMaster);
        if (master == null) {
            log.error("[取消订单] 订单更新失败，orderMaster={}", master);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返还库存
        List<OrderDetail> details = detailDao.findByOrderId(orderMaster.getId());
        if (CollectionUtils.isEmpty(details)) {
            log.error("[取消订单] 订单无详情，orderId={}", orderMaster.getId());
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList = details.stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.increaseStock(cartDTOList);
        //如果支付成功，需要退款
        if (orderMaster.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //TODO :  退款
        }
        return findOneV2(orderDTO.getBuyerOpenid(), orderMaster.getId());
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        OrderMaster orderMaster = masterDao.findOne(orderDTO.getId());
        if (orderMaster == null) {
            log.error("[完结订单] 订单不存在，orderId:{}", orderDTO.getId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW_ORDER.getCode())) {
            log.error("[完结订单] 订单状态不正确，orderid：{},orderStatus:{},datetime:{}", orderMaster.getId(), orderMaster.getOrderStatus(), UtilDateTime.getCurrDateTime());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderMaster.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        OrderMaster master = masterDao.save(orderMaster);
        if (master == null) {
            log.error("[完结订单] 订单更新失败，orderMaster={}", master);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return findOneV2(orderDTO.getBuyerOpenid(),orderMaster.getId());
    }

    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        OrderMaster orderMaster = masterDao.findOne(orderDTO.getId());
        if (orderMaster == null) {
            log.error("[支付订单] 订单不存在，orderId:{}", orderDTO.getId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW_ORDER.getCode())) {
            log.error("[支付订单] 订单状态不正确，orderid：{},orderStatus:{},datetime:{}", orderMaster.getId(), orderMaster.getOrderStatus(), UtilDateTime.getCurrDateTime());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        if (!orderMaster.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("[支付订单] 订单支付状态不正确，orderid：{},orderPayStatus:{},datetime:{}", orderMaster.getId(), orderMaster.getPayStatus(), UtilDateTime.getCurrDateTime());
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }
        orderMaster.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster master = masterDao.save(orderMaster);
        if (master == null) {
            log.error("[支付订单] 订单更新失败，orderMaster={}", master);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return findOneV2(orderDTO.getBuyerOpenid(),orderMaster.getId());
    }
}
