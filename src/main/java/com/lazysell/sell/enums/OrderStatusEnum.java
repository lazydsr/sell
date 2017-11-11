package com.lazysell.sell.enums;

import lombok.Getter;

/**
 * OrderStatusEnum
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.enums
 * Created by Lazy on 2017/11/11 19:24
 * Version: 0.1
 * Info: @TODO:...
 */
@Getter
public enum OrderStatusEnum {
    NEW_ORDER(0, "新订单"),
    FINISH(1, "完成"),
    CANCEL(2, "取消");
    private Integer code;
    private String msg;

    OrderStatusEnum() {

    }

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
