package com.lazysell.sell.service.impl;

import com.lazysell.sell.dao.ProductCategoryDao;
import com.lazysell.sell.pojo.ProductCategory;
import com.lazysell.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductCategoryServiceImpl
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service.impl
 * Created by Lazy on 2017/11/9 22:50
 * Version: 0.1
 * Info: @TODO:...
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao categoryDao;

    @Override
    public ProductCategory findOne(Integer id) {
        return categoryDao.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryNumIn(List<Integer> categoryNumList) {
        return categoryDao.findByCategoryNumIn(categoryNumList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryDao.save(productCategory);
    }
}
