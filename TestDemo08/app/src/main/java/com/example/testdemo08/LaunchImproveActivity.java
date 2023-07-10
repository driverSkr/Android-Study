package com.example.testdemo08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.testdemo08.adapter.LaunchImproveAdapter;
import com.example.testdemo08.adapter.LaunchSimpleAdapter;

public class LaunchImproveActivity extends AppCompatActivity {

    //声明引导页面的图片数组
    private int[] launchImageArray = {R.drawable.guide_bg1,
            R.drawable.guide_bg2, R.drawable.guide_bg3, R.drawable.guide_bg4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_improve);

        ViewPager vp_launch = findViewById(R.id.vp_launch);
        LaunchImproveAdapter adapter = new LaunchImproveAdapter(getSupportFragmentManager(),launchImageArray);
        vp_launch.setAdapter(adapter);
    }
}