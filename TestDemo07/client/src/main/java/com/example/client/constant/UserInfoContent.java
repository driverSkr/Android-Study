package com.example.client.constant;

import android.net.Uri;
import android.provider.BaseColumns;

/*
* BaseColumns有两个基本的常量（_ID、_COUNT），我们实现后就不用自己写了
* */
//配置一些经常用到的常量
public class UserInfoContent implements BaseColumns {

    public static final String AUTHORITIES = "com.example.server.provider.UserInfoProvider";

    // 访问内容提供器的URI
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITIES + "/user");

    // 下面是该表的各个字段名称
    public static final String USER_NAME = "name";
    public static final String USER_AGE = "age";
    public static final String USER_HEIGHT = "height";
    public static final String USER_WEIGHT = "weight";
    public static final String USER_MARRIED = "married";
}
