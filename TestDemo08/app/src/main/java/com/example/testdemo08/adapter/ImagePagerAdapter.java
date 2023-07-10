package com.example.testdemo08.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.testdemo08.ViewPageActivity;
import com.example.testdemo08.entity.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {

    private final Context mContent;
    private final ArrayList<GoodsInfo> mGoodsList;

    //声明一个图像视图列表
    private List<ImageView> mViewList = new ArrayList<>();

    public ImagePagerAdapter(Context mContext, ArrayList<GoodsInfo> mGoodsList) {
        this.mContent = mContext;
        this.mGoodsList = mGoodsList;
        //给每个商品分配一个专门的图像视图
        for (GoodsInfo info : mGoodsList) {
            // 创建一个图像视图对象
            ImageView view = new ImageView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(
                    //设置视图宽、高
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            view.setImageResource(info.pic);
            mViewList.add(view);// 把该商品的图像视图添加到图像视图列表
        }
    }

    @Override// 获取页面项的个数
    public int getCount() {
        return mViewList.size();
    }

    @Override// 判断当前视图是否来自指定对象
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    //实例化指定位置的页面，并将其添加到容器中
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //添加一个view到container中，而后返回一个跟这个view可以关联起来的对象
        //这个对象能够是view自身，也能够是其余对象
        //关键在isViewFromObject可以将view和这个object关联起来
        ImageView item = mViewList.get(position);
        container.addView(item);
        return item;
    }

    //从旧的页面翻到新的页面，从容器中销毁指定位置的页面
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mViewList.get(position));
    }

    @Nullable
    @Override// 获得指定页面的标题文本
    public CharSequence getPageTitle(int position) {
        return mGoodsList.get(position).name;
    }
}
