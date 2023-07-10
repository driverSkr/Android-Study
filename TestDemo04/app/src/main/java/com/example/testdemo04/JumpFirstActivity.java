package com.example.testdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//
public class JumpFirstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_first);

        findViewById(R.id.btn_jump_second).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        //创建一个意图对象，准备跳转到指定的活动页面
        Intent intent = new Intent(this,JumpSecondActivity.class);
        //栈中存在待跳转的活动实例时，则重新创建该活动的实例，并清除原实例上方的所有实例
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}