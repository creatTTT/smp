package com.tu.demo_s_mp.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2020/8/11 0011.
 */
public class B{
    public static void main(String[] args) {


        for(String s:getLastMonthFirstDayAndLastDay1()){
            System.out.println(s);
        }


    }


    public static String getLastMonth(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM");
        String lastMonth=sp.format(d);
        return lastMonth;
    }

    public static String getYesterday(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String yesterday=sp.format(d);//获取昨天日期
        return yesterday;
    }

    public static String[] getLastMonthFirstDayAndLastDay(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1; //当前月份
        int year = cal.get(Calendar.YEAR);//当前年份

        int statisticsYear;
        int statisticsMonth;
        int statisticsMonthLastDate;
        if(month==1){
            statisticsYear=year-1;
            statisticsMonth=12;
        }else {
            statisticsYear=year;
            statisticsMonth=month;
        }

        //判断是否闰年
        if(statisticsYear%4==0 && statisticsMonth==2){
            statisticsMonthLastDate=29;
        }else if(statisticsYear%4!=0 && statisticsMonth==2){
            statisticsMonthLastDate=28;
        }else if(statisticsMonth==1 || statisticsMonth==3 || statisticsMonth==5 || statisticsMonth==7 ||
                statisticsMonth==8 || statisticsMonth==10 || statisticsMonth==12){
            statisticsMonthLastDate=31;
        }else {
            statisticsMonthLastDate=30;
        }
        String sYear=statisticsYear+"";
        String sMonth=statisticsMonth+"";
        String sDay=statisticsMonthLastDate+"";
        if(statisticsMonth<10){
            sMonth="0"+(statisticsMonth+"");
        }

        String timeStart=sYear+"-"+sMonth+"-01 00:00:00";
        String timeEnd=sYear+"-"+sMonth+"-"+sDay+" 23:59:59";
        String flagYearMonth=sYear+sMonth;

        return new String[]{timeStart,timeEnd,flagYearMonth};
    }


    public static String[] getLastMonthFirstDayAndLastDay1(){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");

        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date f=calendar.getTime();
        String lastMonthFirstDay=sp.format(f);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date d=calendar.getTime();
        String lastMonthLastDay=sp.format(d);


        String timeStart=lastMonthFirstDay+" 00:00:00";
        String timeEnd=lastMonthLastDay+" 23:59:59";
        String yearMonth=getLastMonth();

        return new String[]{timeStart,timeEnd,yearMonth};
    }
}
