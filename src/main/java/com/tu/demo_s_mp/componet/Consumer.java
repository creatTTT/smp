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
public class Consumer {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ListOperations<String, String> stringListOperations;

    @PostConstruct
    private void init(){
        stringListOperations = stringRedisTemplate.opsForList();
    }

    public void recive(){
        while (true){
            String message=stringListOperations.rightPop("message");
            if(message==null || message.isEmpty()){
                System.out.println("message is null.");
                break;
            }
            System.out.println("message is => "+message);
        }
    }

}
