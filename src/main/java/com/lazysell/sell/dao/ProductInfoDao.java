package com.lazysell.sell.dao;

import com.lazysell.sell.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ProductInfoDao
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dao
 * Created by Lazy on 2017/11/10 12:33
 * Version: 0.1
 * Info: @TODO:...
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByCategoryNumIn(List<Integer> categoryIdList);

    List<ProductInfo> findByProductStatus(Integer status);
}
