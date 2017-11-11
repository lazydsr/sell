package com.lazysell.sell.service;

import com.lazysell.sell.pojo.ProductCategory;

import java.util.List;

/**
 * ProductCategoryService
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service
 * Created by Lazy on 2017/11/9 22:45
 * Version: 0.1
 * Info: @TODO:...
 */
public interface ProductCategoryService {
    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryNumList);

    ProductCategory save(ProductCategory productCategory);
}
