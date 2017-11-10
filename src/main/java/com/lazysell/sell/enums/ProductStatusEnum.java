package com.lazysell.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * ProductStatusEnum
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.enums
 * Created by Lazy on 2017/11/10 15:51
 * Version: 0.1
 * Info: 商品状态
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "上架"),
    DOWN(1, "下架");
    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;

    }
}
