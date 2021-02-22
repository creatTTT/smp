package com.tu.demo_s_mp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tu
 * @since 2020-06-05
 */
public class Address implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("userId")
    private Integer userId;

    private String city;

    @TableField("addressDetail")
    private String addressDetail;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Override
    public String toString() {
        return "Address{" +
        "userId=" + userId +
        ", city=" + city +
        ", addressDetail=" + addressDetail +
        "}";
    }
}
