package com.example.testdemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testdemo03.utils.DateUtil;

/*
* 按钮点击事件
* *
* 使用OnClickListener类，有四种写法，本例中提供两种，另外两种在ButtonLongClickActivity类中
* 方法一：写一个私有的单独点击事件方法MyOnClickListener，实现View.OnClickListener（最完整，最初始的写法）
* 方法二：在本activity类中直接实现View.OnClickListener，适用于一个视图中有多个点击事件的情况
* */
public class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener {

    static private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        tv_result = findViewById(R.id.tv_result);
        Button btn_click_single = findViewById(R.id.btn_click_single);
        Button btn_click_public = findViewById(R.id.btn_click_public);

        //单独的点击事件监听
        btn_click_single.setOnClickListener(new MyOnClickListener(tv_result));
        //公共的点击事件监听（因为activity本身实现了View.OnClickListener，所以参数就是自己this
        btn_click_public.setOnClickListener(this);
    }

    //指定公共的点击事件，直接让Activity本身实现View.OnClickListener，
    // 这适用于一个视图里有多个点击事件的情况，省的写多个点击方法，直接共用一个
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_click_public){
            String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(),((Button)v).getText());
            tv_result.setText(desc);
        }
    }

    //单独的点击事件监听
    static class MyOnClickListener implements View.OnClickListener{

        private final TextView tv_result;
        public MyOnClickListener(TextView tv_result){
            this.tv_result = tv_result;
        }

        @Override
        public void onClick(View v) {
            String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(),((Button)v).getText());
            tv_result.setText(desc);
        }
    }
}