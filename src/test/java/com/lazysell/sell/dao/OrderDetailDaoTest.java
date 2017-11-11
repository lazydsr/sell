package com.lazysell.sell.dao;

import com.lazy.util.id.UtilUUId;
import com.lazysell.sell.pojo.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * OrderDetailDaoTest
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dao
 * Created by Lazy on 2017/11/11 20:04
 * Version: 0.1
 * Info: @TODO:...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao dao;

    @Test
    public void save(){
        OrderDetail detail = new OrderDetail();
        detail.setId(UtilUUId.getId());
        detail.setOrderId("UAUZHT8U4M58AJTJ4UN65C4WG2XZK72F");
        detail.setProductName("ceshi ");
        detail.setProductId("GZW6G7Z6WTDPAD5KYYQPCZEHFF5QN44G");
        detail.setProductPrice(new BigDecimal("8.22"));
        detail.setProductQuantity(10);
        detail.setProductIcon("http://www.baidu.com");
        dao.save(detail);
    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderList = dao.findByOrderId("UAUZHT8U4M58AJTJ4UN65C4WG2XZK72F");
        System.out.println(orderList);
    }

}