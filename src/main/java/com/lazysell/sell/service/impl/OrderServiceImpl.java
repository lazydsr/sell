package com.lazysell.sell.service.impl;

import com.lazy.util.id.UtilUUId;
import com.lazysell.sell.dao.OrderDetailDao;
import com.lazysell.sell.dao.OrderMasterDao;
import com.lazysell.sell.dto.CartDTO;
import com.lazysell.sell.dto.OrderDTO;
import com.lazysell.sell.enums.ResultEnum;
import com.lazysell.sell.exception.SellException;
import com.lazysell.sell.pojo.OrderDetail;
import com.lazysell.sell.pojo.OrderMaster;
import com.lazysell.sell.pojo.ProductInfo;
import com.lazysell.sell.service.OrderService;
import com.lazysell.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            orderAmount=orderAmount.add(productInfo.getProductPrice().multiply(new BigDecimal(detail.getProductQuantity())));
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
        masterDao.save(orderMaster);

        //4.扣库存
        List<CartDTO> list = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(list);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String openid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
