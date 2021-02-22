package com.tu.demo_s_mp.componet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2020/7/1 0001.
 */

@Component
public class Producer {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ListOperations<String, String> StringListOperations;

    @PostConstruct
    private void init(){
        StringListOperations = stringRedisTemplate.opsForList();
    }

    public void publishMessage(String message){
        System.out.println("message->"+message);
        StringListOperations.leftPush("message",message);
    }
}
