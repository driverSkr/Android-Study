package com.example.testdemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

/*
* 设置文本的颜色
* */
public class TextColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color);

        TextView tv_code_system =  findViewById(R.id.tv_code_system);
        tv_code_system.setTextColor(Color.GREEN);

        TextView tv_code_eight =  findViewById(R.id.tv_code_eight);
        //八位编码FFEEDDCC中，FF表示透明度，EE表示红色的浓度，DD表示绿色的浓度，CC表示蓝色的浓度
        tv_code_eight.setTextColor(0xff00ff00);

        TextView tv_code_six =  findViewById(R.id.tv_code_six);
        //六位编码,在XML文件中默认不透明（等价于透明度为FF），而在代码中默认透明（等价于透明度为00）
        tv_code_six.setTextColor(0x00ff00);

        TextView tv_code_background =  findViewById(R.id.tv_code_background);
        //tv_code_background.setBackgroundColor(Color.GREEN);
        //颜色来自资源
        tv_code_background.setBackgroundResource(R.color.green);
    }
}