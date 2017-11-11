package com.lazysell.sell.utils;

import com.lazysell.sell.vo.ResultVO;

/**
 * ResultVOUtil
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.utils
 * Created by Lazy on 2017/11/11 16:52
 * Version: 0.1
 * Info: @TODO:...
 */
public class ResultVOUtil {
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO success(Object object){
        return new ResultVO(0,"成功",object);
    }
    public static ResultVO error(){
        return error(1,"失败");
    }
    public static ResultVO error(Integer code,String msg){
        return new ResultVO(code,msg,null);
    }
}
