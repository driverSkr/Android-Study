package com.example.testdemo01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","我看到你了！");

        TextView viewById = findViewById(R.id.tv_hello);
        viewById.setText("你好，世界!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        nextPage();

    }

    //跳转到下一个页面
    @SuppressLint("ResourceAsColor")
    private void nextPage(){
        TextView mainView = findViewById(R.id.tv_hello);
        mainView.setText("3秒后跳转到下一个页面...");
        mainView.setTextColor(R.color.purple_500);
        // 延迟3秒（3000毫秒）后启动任务mGoNext
        new Handler(Looper.myLooper()).postDelayed(mGoNext, 3000);
    }

    private Runnable mGoNext = new Runnable() {
        @Override
        public void run() {
            // 活动页面跳转，从MainActivity跳到Main2Activity
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    };

}