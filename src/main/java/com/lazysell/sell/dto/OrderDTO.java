package com.lazysell.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lazysell.sell.enums.OrderStatusEnum;
import com.lazysell.sell.enums.PayStatusEnum;
import com.lazysell.sell.pojo.OrderDetail;
import com.lazysell.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    private List<OrderDetail> orderDetailList;
}
