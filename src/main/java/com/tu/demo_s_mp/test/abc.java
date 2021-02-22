package com.tu.demo_s_mp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2020/8/11 0011.
 */
public class abc {
    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String dateTime = df.format(new Date());
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time2 = calendar.getTimeInMillis();
        System.out.println(time2);

    }
}
