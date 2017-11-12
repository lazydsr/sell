package com.lazysell.sell.converter;

import com.lazysell.sell.dto.OrderDTO;
import com.lazysell.sell.pojo.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster2OrderDTOConverter
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.converter
 * Created by Lazy on 2017/11/12 11:59
 * Version: 0.1
 * Info: @TODO:...
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster master) {
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(master, dto);
        return dto;
    }

    public static List<OrderDTO> convert(List<OrderMaster> masterList) {
        return masterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
