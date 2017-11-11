package com.lazysell.sell.service;

import com.lazysell.sell.dto.OrderDTO;
import com.lazysell.sell.pojo.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * OrderService
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service
 * Created by Lazy on 2017/11/11 20:15
 * Version: 0.1
 * Info: @TODO:...
 */
public interface OrderService {
    /**
     * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询个人订单列表
     */
    Page<OrderDTO> findList(String openid, Pageable pageable);

    /**
     * 取消订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);
}
