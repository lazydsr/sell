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
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    INCREATE_STOCK_ERROR(12, "增加库存不能小于零");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
