package com.lazysell.sell.vo;

import lombok.Data;

import java.util.List;

/**
 * CategoryVO
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.vo
 * Created by Lazy on 2017/11/11 15:23
 * Version: 0.1
 * Info: @TODO:...
 */
@Data
public class CategoryVO {
    private String name;
    private Integer type;
    private List<ProductVO> foods;
}
