package com.tu.demo_s_mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tu.demo_s_mp.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tu
 * @since 2020-06-05
 */
public interface IUserService extends IService<User> {

    List<User> getUsersOrderById();

    //IPage<User> selectUserPage(Page<User> page, Integer state);
    void selectUserPage();

    void sendMessage(String message);

    int getUserCount();

    void registerUser(User user);
}
