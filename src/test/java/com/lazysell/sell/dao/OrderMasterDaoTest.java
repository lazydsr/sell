package com.lazysell.sell.dao;

import com.lazy.util.id.UtilUUId;
import com.lazysell.sell.pojo.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * OrderMasterDaoTest
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.dao
 * Created by Lazy on 2017/11/11 19:45
 * Version: 0.1
 * Info: @TODO:...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao dao;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setId(UtilUUId.getId());
        orderMaster.setBuyerAddress("昌平1");
        orderMaster.setBuyerAmount(new BigDecimal(2.3222));
        orderMaster.setBuyerName("光头强1111");
        orderMaster.setBuyerOpenid("123456");
        orderMaster.setBuyerPhone("13222222222");
        OrderMaster master = dao.save(orderMaster);
        System.out.println(master);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderMaster> page = dao.findByBuyerOpenid("123456", request);
        System.out.println(page);
    }

}