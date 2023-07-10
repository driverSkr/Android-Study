package com.example.testdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

//验证隐式意图
//拨号、准备发短信、打开demo03的计算器
public class ActionUriActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_uri);

        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        findViewById(R.id.btn_my).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String phoneNo = "12345";
        switch (v.getId()){
            case R.id.btn_dial:
                //设置意图动作为准备拨号
                intent.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+phoneNo);
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.btn_sms:
                //设置意图动作为发短信
                intent.setAction(Intent.ACTION_SENDTO);
                //声明一个发送短信的Uri
                Uri uri1 = Uri.parse("smsto"+ phoneNo);
                intent.setData(uri1);
                startActivity(intent);
                break;
            case R.id.btn_my:
                //这是写在TestDemo03的清单文件中的intent-filter里的值
                //点击跳转到demo03的程序，计算器
                intent.setAction("android.intent.action.NING");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
                break;
        }
    }
}