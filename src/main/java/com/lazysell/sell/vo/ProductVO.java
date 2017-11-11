package com.lazysell.sell.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ProductVO
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.vo
 * Created by Lazy on 2017/11/11 15:26
 * Version: 0.1
 * Info: @TODO:...
 */
@Data
public class ProductVO {
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private String icon;
}
