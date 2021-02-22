package com.tu.demo_s_mp.service.serviceImpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tu.demo_s_mp.entity.User;
import com.tu.demo_s_mp.mapper.UserMapper;
import com.tu.demo_s_mp.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/8 0008.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {


    @Autowired
    private IUserService useService;

    @Autowired
    UserMapper userMapper;


    @Test
    public void testSelectUserPage() throws Exception {
        useService.selectUserPage();
    }


    @Test
    public void lambdaPagination() {
        Page<User> page = new Page<>(2, 3);
        Page<User> result = userMapper.selectPage(page, Wrappers.<User>lambdaQuery().eq(User::getAge, 1).orderByAsc(User::getAge));
        List<User> userList = result.getRecords();
        userList.forEach(System.out::println);
    }


    @Test
    public void testgetUserCount() throws Exception {
        System.out.println(useService.getUserCount());
    }


    @Test
    public void contextLoads() {
        List li=new ArrayList<>();
        li.add("efef");li.add("vfbf");
        li.add("ttt");
        li.add("ejjjfef");
        li.forEach(System.out::println);
    }


}