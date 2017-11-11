package com.lazysell.sell.enums;

import lombok.Getter;

/**
 * PayStatusEnum
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.enums
 * Created by Lazy on 2017/11/11 19:30
 * Version: 0.1
 * Info: @TODO:...
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "已支付");

    private Integer code;
    private String msg;

    PayStatusEnum() {
    }

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
