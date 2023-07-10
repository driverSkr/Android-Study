package com.example.testdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testdemo04.utils.DateUtil;

//接收ActRequestActivity传过来的数据，并回应
public class ActResponseActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String mResponse = "我还没睡，我爸妈不在家";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_response);

        TextView tv_request = findViewById(R.id.tv_request);
        //从上一个页面传来的意图中获取快递包裹
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");

        //格式化信息
        String desc = String.format("收到请求消息：\n请求时间为 %s\n请求内容为 %s",request_time,request_content);
        tv_request.setText(desc);

        TextView tv_response = findViewById(R.id.tv_response);
        tv_response.setText("待返回的消息为："+mResponse);

        findViewById(R.id.btn_response).setOnClickListener(this);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("response_time", DateUtil.getNowTime());
        bundle.putString("response_content",mResponse);
        intent.putExtras(bundle);
        //携带意图返回上一个页面。RESULT_OK表示处理成功
        setResult(Activity.RESULT_OK,intent);
        //关闭本页面，回到上一个页面
        finish();
    }
}