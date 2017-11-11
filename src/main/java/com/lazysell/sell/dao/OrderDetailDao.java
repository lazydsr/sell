package com.lazysell.sell.dao;

import com.lazysell.sell.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * OrderDetailDao
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dao
 * Created by Lazy on 2017/11/11 19:42
 * Version: 0.1
 * Info: @TODO:...
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
