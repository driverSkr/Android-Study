package com.example.testdemo08.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.testdemo08.entity.GoodsInfo;
import com.example.testdemo08.fragment.DynamicFragment;

import java.util.List;

/**
 * 动态注册Fragment（改造ViewPage）
 */
public class MobilePagerAdapter extends FragmentPagerAdapter {

    // 声明一个商品列表
    private final List<GoodsInfo> mGoodsList;

    // 碎片页适配器的构造方法，传入碎片管理器与商品信息列表
    public MobilePagerAdapter(@NonNull FragmentManager fm, List<GoodsInfo> goodsList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mGoodsList = goodsList;
    }

    @NonNull
    @Override// 获取指定位置的碎片Fragment
    public Fragment getItem(int position) {
        GoodsInfo info = mGoodsList.get(position);
        return DynamicFragment.newInstance(position,info.pic,info.description);
    }

    @Override// 获取碎片Fragment的个数
    public int getCount() {
        return mGoodsList.size();
    }

    @Nullable
    @Override// 获得指定碎片页的标题文本
    public CharSequence getPageTitle(int position) {
        return mGoodsList.get(position).name;
    }
}
