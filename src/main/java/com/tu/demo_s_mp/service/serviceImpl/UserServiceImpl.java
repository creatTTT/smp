package com.tu.demo_s_mp.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tu.demo_s_mp.entity.User;
import com.tu.demo_s_mp.mapper.UserMapper;
import com.tu.demo_s_mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tu
 * @since 2020-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUsersOrderById(){
        return userMapper.getUsersOrderById();
    }


    public void selectUserPage() {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个

        Page<User> page = new Page<>(2, 4);
        page.addOrder(OrderItem.asc("age"));
        Page<User> userIPage = userMapper.selectPage(page, Wrappers.<User>lambdaQuery().lt(User::getAge, 40));
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void sendMessage(String message){
        try {
            stringRedisTemplate.convertAndSend("myChannel", message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public void registerUser(User user) {
        userMapper.registerUser(user);
    }

}
