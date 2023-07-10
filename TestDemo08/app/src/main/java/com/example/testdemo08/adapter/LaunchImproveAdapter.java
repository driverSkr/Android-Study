package com.example.testdemo08.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.testdemo08.fragment.LaunchFragment;

public class LaunchImproveAdapter extends FragmentPagerAdapter {

    private final int[] mImageArray;// 声明一个图片数组

    // 碎片页适配器的构造方法，传入碎片管理器与图片数组
    public LaunchImproveAdapter(FragmentManager fm, int[] imageArray) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mImageArray = imageArray;
    }

    @NonNull
    @Override// 获取指定位置的碎片Fragment
    public Fragment getItem(int position) {
        return LaunchFragment.newInstance(getCount(),position,mImageArray[position]);
    }

    @Override// 获取碎片Fragment的个数
    public int getCount() {
        return mImageArray.length;
    }
}
