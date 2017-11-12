package com.lazysell.sell.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * OrderForm
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.form
 * Created by Lazy on 2017/11/12 16:26
 * Version: 0.1
 * Info: @TODO:...
 */
@Data
public class OrderForm {
    @NotNull(message = "姓名必填")
    private String name;
    @NotNull(message = "手机号码必填")
    private String phone;
    @NotNull(message = "地址必填")
    private String address;
    @NotNull(message = "openid必填")
    private String openid;
    private String items;

}
