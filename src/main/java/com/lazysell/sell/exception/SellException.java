package com.lazysell.sell.exception;

import com.lazysell.sell.enums.ResultEnum;

/**
 * SellException
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.exception
 * Created by Lazy on 2017/11/11 21:34
 * Version: 0.1
 * Info: @TODO:...
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
