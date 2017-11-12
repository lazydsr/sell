package com.lazysell.sell.controller;

import com.lazysell.sell.converter.OrderForm2OrderDTOConverter;
import com.lazysell.sell.dto.OrderDTO;
import com.lazysell.sell.enums.ResultEnum;
import com.lazysell.sell.exception.SellException;
import com.lazysell.sell.form.OrderForm;
import com.lazysell.sell.service.OrderService;
import com.lazysell.sell.utils.ResultVOUtil;
import com.lazysell.sell.vo.ResultVO;
import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * BuyerOrderController
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.controller
 * Created by Lazy on 2017/11/12 16:20
 * Version: 0.1
 * Info: @TODO:...
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    //创建订单
    @RequestMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】：表单信息不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO dto = orderService.create(OrderForm2OrderDTOConverter.convert(orderForm));
        OrderDTO orderDTO = orderService.create(dto);
        if (orderDTO == null) {
            log.error("【创建订单】：创建订单失败，orderForm={}", orderForm);
            throw new SellException(ResultEnum.ORDER_CREATE_FAIL);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("orderId", orderDTO.getId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(String openid,
                                         @RequestParam(name = "page", defaultValue = "0") Integer page,
                                         @RequestParam(name = "size", defaultValue = "10") Integer size) {
        if (org.springframework.util.StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】：openid不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        Page<OrderDTO> orderDTOS = orderService.findList(openid, new PageRequest(page, size));
        return ResultVOUtil.success(orderDTOS.getContent());
    }

    //订单详情
    @RequestMapping("/detail")
    public ResultVO detail(String openid, String orderId) {
        //TODO:不安全
        OrderDTO orderDTO = orderService.findOneV2(openid,orderId);
        return ResultVOUtil.success(orderDTO);
    }
    //取消订单
    @RequestMapping("/cancel")
    public ResultVO cancel(String openid, String orderId) {
        //TODO:不安全
        OrderDTO dto = new OrderDTO();
        dto.setBuyerOpenid(openid);
        dto.setId(orderId);
        OrderDTO orderDTO = orderService.cancel(dto);
        return ResultVOUtil.success();
    }
}
