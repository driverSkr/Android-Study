package com.example.testdemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*
* 滚动视图
* *
* 垂直滚动视图名为ScrollView，
* 水平滚动视图名为HorizontalScrollView
* */
public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }
}