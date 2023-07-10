package com.example.testdemo08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.testdemo08.adapter.LaunchSimpleAdapter;

/*
* 使用ViewPager实现启动引导页
* */
public class LaunchSimpleActivity extends AppCompatActivity {

    //声明引导页面的图片数组
    private int[] launchImageArray = {R.drawable.guide_bg1,
            R.drawable.guide_bg2, R.drawable.guide_bg3, R.drawable.guide_bg4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_simple);

        ViewPager vp_launch = findViewById(R.id.vp_launch);
        LaunchSimpleAdapter adapter = new LaunchSimpleAdapter(this, launchImageArray);
        vp_launch.setAdapter(adapter);
    }
}