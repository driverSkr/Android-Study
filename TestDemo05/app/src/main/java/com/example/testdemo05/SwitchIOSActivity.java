package com.example.testdemo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/*使用CheckBox实现自定义开关按钮Switch*/
public class SwitchIOSActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_iosactivity);

        CheckBox sw_status = findViewById(R.id.ck_status);
        tv_result = findViewById(R.id.tv_result);
        sw_status.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String desc = String.format("Switch按鈕的狀態是%s ",isChecked ? "開" : "關");
        tv_result.setText(desc);
    }
}