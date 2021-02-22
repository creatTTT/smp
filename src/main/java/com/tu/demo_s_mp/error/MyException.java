package com.tu.demo_s_mp.error;

/**
 * Created by Administrator on 2021/1/28 0028.
 */
public class MyException extends  RuntimeException {

    private String msg;

    public MyException(String msg){
        super(msg);
    }

}
