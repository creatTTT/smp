package com.tu.demo_s_mp.componet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020/7/1 0001.
 */
@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(String message){
        System.out.println("Receive: " + message);
    }
}
