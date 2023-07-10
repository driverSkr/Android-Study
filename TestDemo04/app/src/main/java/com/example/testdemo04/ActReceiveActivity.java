package com.example.testdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//接受ActSendActivity发来的数据
public class ActReceiveActivity extends AppCompatActivity {

    private TextView tv_receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);

        tv_receive = findViewById(R.id.tv_receive);
        //从上一个页面传来的意图中获取快递包裹（getIntent()是Activity的方法
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");

        //格式化信息
        String desc = String.format("收到请求消息：\n请求时间为 %s\n请求内容为 %s",request_time,request_content);

        tv_receive.setText(desc);
    }
}