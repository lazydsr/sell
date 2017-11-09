package com.lazysell.sell.service.impl;

import com.lazysell.sell.pojo.ProductCategory;
import com.lazysell.sell.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ProductCategoryServiceImplTest
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service.impl
 * Created by Lazy on 2017/11/9 22:53
 * Version: 0.1
 * Info: @TODO:...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryService categoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory serviceOne = categoryService.findOne(1);
        System.out.println(serviceOne);
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findByCategoryNumIn() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

}