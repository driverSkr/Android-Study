package com.example.testdemo08.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdemo08.R;

/**
 * 动态注册Fragment（改造ViewPage）
 */
public class DynamicFragment extends Fragment {

    // 获取该碎片的一个实例
    public static DynamicFragment newInstance(int position,int image_id,String desc) {
        DynamicFragment fragment = new DynamicFragment();// 创建该碎片的一个实例
        //把参数打包，传入fragment中
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("image_id", image_id);
        args.putString("desc", desc);
        fragment.setArguments(args);// 把包裹塞给碎片
        return fragment;
    }

    //从包裹取出位置序号
    private int getPosition(){
        return getArguments().getInt("position",0);
    }

    //创建碎片视图
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //根据布局文件fragment_dynamic.xml生成视图对象
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        Bundle arguments = getArguments();
        if (arguments != null){ // 如果碎片携带有包裹，就打开包裹获取参数信息
            ImageView iv_pic = view.findViewById(R.id.iv_pic);
            TextView tv_desc = view.findViewById(R.id.tv_desc);

            iv_pic.setImageResource(arguments.getInt("image_id",R.drawable.huawei));
            tv_desc.setText(arguments.getString("desc"));
        }

        return view;
    }
}