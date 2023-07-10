package com.example.testdemo04;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testdemo04.utils.DateUtil;

//发送数据给ActResponseActivity,并期待数据回传
public class ActRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private String mRequest = "你睡了吗？来我家睡吧";
    private ActivityResultLauncher<Intent> register;
    private TextView tv_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_request);

        TextView tv_request = findViewById(R.id.tv_request);
        tv_request.setText("待发送的消息为："+mRequest);
        //期待回传的消息
        tv_response = findViewById(R.id.tv_response);

        findViewById(R.id.btn_request).setOnClickListener(this);

        //对回传消息的处理（新方法，替代了startActivityForResult）
        register =  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
            if (result != null){
                //回传的Intent，封装的Bundle放在里面
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK){
                    //获得回传的数据包裹
                    Bundle bundle = intent.getExtras();
                    String response_time = bundle.getString("response_time");
                    String response_content = bundle.getString("response_content");
                    String desc = String.format("收到返回消息： \n应答时间为 %s\n应答内容为 %s",response_time,response_content);
                    //把返回消息的详情显示在本文视图上
                    tv_response.setText(desc);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,ActResponseActivity.class);
        //创建一个包裹
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content",mRequest);
        intent.putExtras(bundle);
        //消息传给ActResponseActivity，并请求回传数据
        register.launch(intent);
    }
}