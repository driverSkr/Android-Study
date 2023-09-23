package com.example.groupControls.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.groupControls.fragment.AppliancesFragment;
import com.example.groupControls.fragment.ClothesFragment;

import java.util.List;

public class ClassPagerAdapter extends FragmentStateAdapter {
    private List<String> mTitleList; // 声明一个标题文字列表

    // 碎片页适配器的构造方法，传入碎片管理器与标题列表
    public ClassPagerAdapter(@NonNull FragmentActivity fa, List<String> titleList) {
        super(fa);
        mTitleList = titleList;
    }

    // 创建指定位置的碎片Fragmen
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) { // 第一页展示服装
            return new ClothesFragment();
        } else { // 其他页展示电器
            return new AppliancesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }
}
