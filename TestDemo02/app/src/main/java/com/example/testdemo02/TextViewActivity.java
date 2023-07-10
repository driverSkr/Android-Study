package com.example.testdemo02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class TextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // 活动页面跳转，从MainActivity跳到TextViewActivity
                /*另一种完整的写法
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,TextViewActivity.class);
                startActivity(intent);*/
            }
        });
    }
}