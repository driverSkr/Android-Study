package com.example.testdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
//跳转的页面，设置方法返回上一个页面
public class ActFinishActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_finish);

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_finish).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        //返回上个页面
        finish();
    }
}