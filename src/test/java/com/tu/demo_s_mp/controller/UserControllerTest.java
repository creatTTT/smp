package com.tu.demo_s_mp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2021/1/27 0027.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {


    @Autowired
    UserController userController;
    @Test
    public void testGetAllUser() throws Exception {
        System.out.println(userController.getAllUser());
    }

    @Test
    public void testGetAgeEqOne() throws Exception {

    }
}