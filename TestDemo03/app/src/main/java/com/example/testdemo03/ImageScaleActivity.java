package com.example.testdemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/*
* 图像视图ImageView
* */
public class ImageScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);

        ImageView iv_scale = findViewById(R.id.iv_scale);
        iv_scale.setImageResource(R.drawable.apple);
        // 将缩放类型设置为“保持宽高比例，缩放图片使其位于视图中间”
        iv_scale.setScaleType(ImageView.ScaleType.FIT_CENTER);

    }
}