package com.example.testdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MetaDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta_data);

        TextView tv_meta = findViewById(R.id.tv_meta);
        //获取应用包管理器
        PackageManager pm = getPackageManager();
        try {
            //getActivityInfo(获取本组件名称, 获取什么信息);
            ActivityInfo info = pm.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Bundle metaData = info.metaData;
            String weather = metaData.getString("weather");
            tv_meta.setText(weather);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}