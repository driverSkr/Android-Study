package com.example.testdemo06.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUtil {

    private static SharedUtil mUtil;
    private SharedPreferences preferences;

    public static SharedUtil getInstance(Context context){
        if (mUtil == null){
            mUtil = new SharedUtil();
            mUtil.preferences = context.getSharedPreferences("shopping",Context.MODE_PRIVATE);
        }
        return mUtil;
    }

    //写操作
    public void writeBoolean(String key,boolean value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    //读操作
    public boolean readBoolean(String key,boolean defaultValue){
        return preferences.getBoolean(key,defaultValue);
    }
}
