package com.lazysell.sell.vo;

import lombok.Data;

/**
 * ResultVO
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.vo
 * Created by Lazy on 2017/11/11 15:09
 * Version: 0.1
 * Info: @TODO:...
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
