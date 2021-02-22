package com.tu.demo_s_mp.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2021/1/28 0028.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {
    private int code;
    private String message;
    private Object data;
}
