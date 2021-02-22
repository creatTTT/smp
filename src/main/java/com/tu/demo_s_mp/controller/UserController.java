package com.tu.demo_s_mp.controller;


import com.tu.demo_s_mp.annotation.SysLogAnnotation;
import com.tu.demo_s_mp.componet.Consumer;
import com.tu.demo_s_mp.componet.Producer;
import com.tu.demo_s_mp.entity.User;
import com.tu.demo_s_mp.error.CommonResult;
import com.tu.demo_s_mp.error.ResponseCode;
import com.tu.demo_s_mp.service.IUserService;
import com.tu.demo_s_mp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tu
 * @since 2020-06-05
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService useService;


    @Autowired
    Consumer consumer;
    @Autowired
    Producer producer;


    @GetMapping("getAllUser")
    @SysLogAnnotation("查询所有用户")
    public R getAllUser(){
        R r=R.ok(useService.getUsersOrderById());
        int a=10/0;
        return r;
    }

    @GetMapping("getAgeEqOne")
    public R getAgeEqOne(){
        return R.ok(useService.lambdaQuery().eq(User::getAge,1).list());
    }

    @GetMapping("/index")
    public int index(){
        int a=10/0;
        return a;

    }

    @GetMapping("/register")
    public CommonResult register( User User){
        //一连串注册的业务
        useService.registerUser(User);
        return new CommonResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(),"");
    }


    @GetMapping("/send/{message}")
    public void sendMeaasge(@PathVariable("message") String message){
        producer.publishMessage(message);
    }
    @GetMapping("/receive")
    public void receive(){
        consumer.recive();
    }

    @GetMapping("/sends/{message}")
    public void sendMessage(@PathVariable("message") String message){
        useService.sendMessage(message);
    }
}

