package com.example.testdemo08.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testdemo08.R;
import com.example.testdemo08.entity.Planet;
import com.example.testdemo08.util.ToastUtil;

import java.util.List;

/*
* 优化PlanetBaseAdapter：convert复用view
* */
public class PlanetListWithButtonAdapter extends BaseAdapter {

    private Context mContext;
    private List<Planet> mPlaneList;

    public PlanetListWithButtonAdapter(Context mContext, List<Planet> mPlaneList) {
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
        ViewHolder holder;
        if (convertView == null){
            //根据布局文件item_list.mxl生成转换视图对象
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_with_button, null);
            holder = new ViewHolder();
            holder.ll_item = convertView.findViewById(R.id.ll_item);
            holder.iv_icon = convertView.findViewById(R.id.iv_icon);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_desc = convertView.findViewById(R.id.tv_desc);
            holder.btn_oper = convertView.findViewById(R.id.btn_oper);
            // 将视图持有者保存到转换视图当中
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        //给控件设置好数据
        Planet planet = mPlaneList.get(position);
        //阻止下级控件获得焦点，避免堵塞列表视图的点击事件(Java代码版)
     //   holder.ll_item.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        holder.iv_icon.setImageResource(planet.image);
        holder.tv_name.setText(planet.name);
        holder.tv_desc.setText(planet.desc);
        holder.btn_oper.setOnClickListener(v -> {
            ToastUtil.show(mContext,"按钮被点击了，"+planet.name);
        });
        return convertView;
    }

    public final class ViewHolder {
        public LinearLayout ll_item;//最大的容器布局
        public ImageView iv_icon;
        public TextView tv_name;
        public TextView tv_desc;
        public Button btn_oper;
    }
}
