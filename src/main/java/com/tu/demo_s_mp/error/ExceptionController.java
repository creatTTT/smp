package com.tu.demo_s_mp.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Administrator on 2021/1/28 0028.
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(Exception e){
        //如果抛出的异常属于自定义异常，就以JSON格式返回

        if (e instanceof MyException){
            return new CommonResult(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMsg(),"自定义的错误为："+e.getMessage());
        }
        //如果都不是就打印出异常的信息
        return new CommonResult(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMsg(),"错误的信息为000："+e.getMessage());
    }

    /*@ExceptionHandler(value = RuntimeException.class)
    public CommonResult RunTimeexceptionHandler(RuntimeException e){
        //如果抛出的异常属于自定义异常，就以JSON格式返回
        if (e instanceof RuntimeException){
            return new CommonResult(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMsg(),"RuntimeException："+e.getMessage());
        }
        //如果都不是就打印出异常的信息
        return new CommonResult(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMsg(),"错误的信息为："+e.getMessage());
    }*/
}
