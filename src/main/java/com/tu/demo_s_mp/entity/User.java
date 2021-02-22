package com.tu.demo_s_mp.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tu
 * @since 2020-06-05
 */
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer userId;

    private String username;

    private Integer age;

    private Integer sex;

    private Integer phoneNumber;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", username=" + username +
        ", age=" + age +
        ", sex=" + sex +
        ", phoneNumber=" + phoneNumber +
        "}";
    }
}
