package com.example.testdemo05.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.testdemo05.R;

public class LogTestActivity extends AppCompatActivity {

    private String msg = "我看到你了";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_test);

        findViewById(R.id.btn_click).setOnClickListener(v -> {
            Log.e("BoGe","表示错误信息:"+msg);
            Log.w("BoGe","表示警告信息:"+msg);
            Log.i("BoGe","表示一般消息:"+msg);
            Log.d("BoGe","表示调试信息:"+msg);
            Log.v("BoGe","表示冗余信息:"+msg);
        });
    }
}