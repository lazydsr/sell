package com.lazysell.sell.enums;

import lombok.Getter;

/**
 * ResultEnum
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.enums
 * Created by Lazy on 2017/11/11 21:31
 * Version: 0.1
 * Info: @TODO:...
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数不正确" ),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    INCREATE_STOCK_ERROR(12, "增加库存不能小于零"),
    ORDER_NOT_EXIST(13, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(14, "订单详情不存在"),
    ORDER_STATUS_ERROR(15, "订单状态不正确"),
    ORDER_UPDATE_FAIL(16, "订单更新失败"),
    ORDER_DETAIL_EMPTY(17, "订单无商品"),
    ORDER_PAY_STATUS_ERROR(18,"订单支付状态不正确" ),
    ORDER_CREATE_FAIL(19,"订单创建失败" ),
    ORDER_OWNER_ERROR(20,"订单与openid对应错误" );

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
