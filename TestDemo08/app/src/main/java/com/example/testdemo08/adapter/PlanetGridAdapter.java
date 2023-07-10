package com.example.testdemo08.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdemo08.R;
import com.example.testdemo08.entity.Planet;

import java.util.List;

public class PlanetGridAdapter extends BaseAdapter {

    private Context mContext;
    private List<Planet> mPlaneList;

    public PlanetGridAdapter(Context mContext, List<Planet> mPlaneList) {
        this.mContext = mContext;
        this.mPlaneList = mPlaneList;
    }

    //列表项的个数
    @Override
    public int getCount() {
        return mPlaneList.size();
    }

    //对应的条目
    @Override
    public Object getItem(int position) {
        return mPlaneList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //获取item视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //根据布局文件item_list.mxl生成转换视图对象
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_grid, null);
        ImageView iv_icon = view.findViewById(R.id.iv_icon);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_desc = view.findViewById(R.id.tv_desc);
        //给控件设置好数据
        Planet planet = mPlaneList.get(position);
        iv_icon.setImageResource(planet.image);
        tv_name.setText(planet.name);
        tv_desc.setText(planet.desc);

        return view;
    }
}
