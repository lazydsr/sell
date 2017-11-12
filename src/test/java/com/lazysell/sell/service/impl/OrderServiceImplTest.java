package com.lazysell.sell.service.impl;

import com.lazysell.sell.dto.OrderDTO;
import com.lazysell.sell.pojo.OrderDetail;
import com.lazysell.sell.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * OrderServiceImplTest
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.service.impl
 * Created by Lazy on 2017/11/11 22:36
 * Version: 0.1
 * Info: @TODO:...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("安丘");
        orderDTO.setBuyerName("美女");
        orderDTO.setBuyerOpenid("1234567890");
        orderDTO.setBuyerPhone("13222222222");

        List<OrderDetail> list = new ArrayList<>();
        OrderDetail detail = new OrderDetail();
        detail.setProductId("PEW4V8XRYYPFQGVKK2BNRYZMHZZGKE6T");
        detail.setProductQuantity(100);
        list.add(detail);
        orderDTO.setOrderDetailList(list);
        OrderDTO dto = orderService.create(orderDTO);
        System.out.println(dto);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1RU2WVZ6UZE8HN1JKR86WRNE2UJNMEHS");
        System.out.println(orderDTO);
    }

    @Test
    public void findList() throws Exception {
        Page<OrderDTO> orderDTOS = orderService.findList("1234567890", new PageRequest(0, 3));
        System.out.println(orderDTOS);
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO dto = new OrderDTO();
        dto.setId("1RU2WVZ6UZE8HN1JKR86WRNE2UJNMEHS");
        OrderDTO orderDTO = orderService.cancel(dto);
        System.out.println(orderDTO);
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void paid() throws Exception {
        OrderDTO dto = new OrderDTO();
        dto.setId("1RU2WVZ6UZE8HN1JKR86WRNE2UJNMEHS");
        OrderDTO orderDTO = orderService.paid(dto);
        System.out.println(orderDTO);
    }

}