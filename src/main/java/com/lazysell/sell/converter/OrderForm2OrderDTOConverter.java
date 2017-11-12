package com.lazysell.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lazy.util.json.UtilJson;
import com.lazysell.sell.dto.OrderDTO;
import com.lazysell.sell.enums.ResultEnum;
import com.lazysell.sell.exception.SellException;
import com.lazysell.sell.form.OrderForm;
import com.lazysell.sell.pojo.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * OrderForm2OrderDTOConverter
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.converter
 * Created by Lazy on 2017/11/12 16:46
 * Version: 0.1
 * Info: @TODO:...
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
