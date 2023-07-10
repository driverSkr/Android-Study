package com.example.testdemo08.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdemo08.R;

/*
* 静态注册Fragment碎片
* */
public class StaticFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "StaticFragment";
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象

    // 创建碎片视图
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity(); // 获取活动页面的上下文
        // 根据布局文件fragment_static.xml生成视图对象
        mView = inflater.inflate(R.layout.fragment_static, container, false);
        TextView tv_adv = mView.findViewById(R.id.tv_adv);
        ImageView iv_adv = mView.findViewById(R.id.iv_adv);
        tv_adv.setOnClickListener(this); // 设置点击监听器
        iv_adv.setOnClickListener(this); // 设置点击监听器
        Log.d(TAG, "onCreateView");
        return mView; // 返回该碎片的视图对象
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_adv) {
            Toast.makeText(mContext, "您点击了广告文本", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.iv_adv) {
            Toast.makeText(mContext, "您点击了广告图片", Toast.LENGTH_LONG).show();
        }
    }
}