package com.example.testdemo03.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 时间工具类
* 获取当前的时间
* */
public class DateUtil {

    public static String getNowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
}
