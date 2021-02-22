package com.tu.demo_s_mp.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2021/1/29 0029.
 */
public class NoSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, i + "").start();
        }
        // 正确结果
        // [3fb16395]
        // [3fb16395, 4b2551d6]
        // [3fb16395, 4b2551d6, a6f52743]

        // 但是偶尔会这样
        // [null, f69d4ac4]
        // [null, f69d4ac4, 41e8ffc4]
        // [null, f69d4ac4]


    }
}
