package com.tu.demo_s_mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Goods implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "goodId", type = IdType.AUTO)
    private Integer goodId;

    @TableField("goodName")
    private String goodName;

    private Double price;


    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
        "goodId=" + goodId +
        ", goodName=" + goodName +
        ", price=" + price +
        "}";
    }
}
