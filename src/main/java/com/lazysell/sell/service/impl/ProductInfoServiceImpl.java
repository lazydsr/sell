package com.lazysell.sell.service.impl;

import com.lazysell.sell.dao.ProductInfoDao;
import com.lazysell.sell.enums.ProductStatusEnum;
import com.lazysell.sell.pojo.ProductInfo;
import com.lazysell.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * ProductInfoServiceImpl
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service.impl
 * Created by Lazy on 2017/11/10 15:49
 * Version: 0.1
 * Info: @TODO:...
 */
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

}
