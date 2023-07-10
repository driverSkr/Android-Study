package com.example.testdemo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/*安卓默认 开关按钮Switch*/
public class SwitchDefaultActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_default);

        Switch sw_status = findViewById(R.id.sw_status);
         tv_result = findViewById(R.id.tv_result);
         sw_status.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String desc = String.format("Switch按鈕的狀態是%s ",isChecked ? "開" : "關");
        tv_result.setText(desc);
    }
}