package com.lazysell.sell.service;

import com.lazysell.sell.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * ProductInfoService
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service
 * Created by Lazy on 2017/11/10 15:45
 * Version: 0.1
 * Info: @TODO:...
 */
public interface ProductInfoService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有上架的商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);

}
