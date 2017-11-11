package com.lazysell.sell.dto;

import com.lazysell.sell.enums.OrderStatusEnum;
import com.lazysell.sell.enums.PayStatusEnum;
import com.lazysell.sell.pojo.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * OrderDTO
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dto
 * Created by Lazy on 2017/11/11 20:20
 * Version: 0.1
 * Info: @TODO:...
 */
@Data
public class OrderDTO {
    private String id;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal buyerAmount;
    /**
     * 订单状态  默认为下单 0
     */
    private Integer orderStatus = OrderStatusEnum.NEW_ORDER.getCode();
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    private String createTime;
    private String updateTime;
    private List<OrderDetail> orderDetailList;
}
