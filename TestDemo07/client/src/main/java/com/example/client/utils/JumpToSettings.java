package com.example.client.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

public class JumpToSettings {
    //跳转到应用设置界面(隐式意图)【可删除应用】
    public static void jumpToSettings(Context context){
        Intent intent = new Intent();
        //设置详情界面
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        //携带本页面的包名，标明来源
        intent.setData(Uri.fromParts("package",context.getPackageName(),null));
        //设置启动模式
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
