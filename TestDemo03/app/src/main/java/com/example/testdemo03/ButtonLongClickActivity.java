package com.example.testdemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testdemo03.utils.DateUtil;

/*
* 按钮长按点击事件
* *
* 使用OnLongClickListener类
* 本类中写了另外两种编写点击监听事件的方法
* 方法一：使用匿名内部类的方式设置监听事件
* 方法二：使用lambda表达式的形式简化匿名内部类的写法（匿名内部类的简写方式）
* */
public class ButtonLongClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_long_click);

        Button btn_long_click = findViewById(R.id.btn_long_click);
        TextView tv_result = findViewById(R.id.tv_result);

        //使用匿名内部类的方式设置监听事件
        /*btn_long_click.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(),((Button)v).getText());
                tv_result.setText(desc);
                return true;
            }
        });*/

        //使用lambda表达式的形式简化匿名内部类的写法
        btn_long_click.setOnLongClickListener(v -> {
            String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(),((Button)v).getText());
            tv_result.setText(desc);
            return true;
        });

    }
}