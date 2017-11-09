package com.lazysell.sell.dao;

import com.lazysell.sell.pojo.ProductCategory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * ProductCategoryDaoTest
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dao
 * Created by Lazy on 2017/11/9 21:40
 * Version: 0.1
 * Info: @TODO:...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory);
        log.error(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveOneTest() {
        ProductCategory category = productCategoryDao.findOne(2);

        category.setCategoryNum(13);
        productCategoryDao.save(category);
        System.out.println(productCategoryDao.findAll());
    }
    @Test
    public void findByProductCategoryNumInTest(){
        List<ProductCategory> result = productCategoryDao.findByCategoryNumIn(Arrays.asList(2, 5, 4));
        Assert.assertNotEquals(0,result.size());
    }
}