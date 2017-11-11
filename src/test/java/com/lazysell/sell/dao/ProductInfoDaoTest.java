package com.lazysell.sell.dao;

import com.lazy.util.id.UtilUUId;
import com.lazysell.sell.pojo.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * ProductInfoDaoTest
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dao
 * Created by Lazy on 2017/11/10 14:11
 * Version: 0.1
 * Info: @TODO:...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(UtilUUId.getId());
        productInfo.setProductName("mobile");
        productInfo.setProductPrice(new BigDecimal(100));
        productInfo.setProductStock(110);
        productInfo.setCategoryType(10);
        productInfo.setProductStatus(1);

        ProductInfo info = productInfoDao.save(productInfo);
        System.out.println(info);


    }

    @Test
    public void findByCategoryNumIn() throws Exception {
    }

    @Test
    public void findByProductStatus() throws Exception {
    }

}