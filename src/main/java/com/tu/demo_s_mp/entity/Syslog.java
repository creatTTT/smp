package com.tu.demo_s_mp.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Syslog extends Model<Syslog> {

    private static final long serialVersionUID=1L;

      private Long id;

    private String username;

    private String nickname;

    private String operation;

    private String method;

    private String params;

    private Long time;

    private String ip;

    @TableField("createDate")
    private LocalDateTime createDate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
