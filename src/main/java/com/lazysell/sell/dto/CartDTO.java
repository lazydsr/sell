package com.lazysell.sell.dto;

import lombok.Data;

/**
 * CartDTO
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dto
 * Created by Lazy on 2017/11/11 22:11
 * Version: 0.1
 * Info: 购物车
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
