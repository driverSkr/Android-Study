package com.example.testdemo08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;

import com.example.testdemo08.adapter.ImagePagerAdapter;
import com.example.testdemo08.adapter.MobilePagerAdapter;
import com.example.testdemo08.entity.GoodsInfo;

import java.util.ArrayList;

/**
 * 动态注册Fragment（改造ViewPage）
 */
public class FragmentDynamicActivity extends AppCompatActivity {

    private ArrayList<GoodsInfo> mGoodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);

        initPagerStrip();
        initViewPager();
    }
    // 初始化翻页标签栏
    private void initPagerStrip() {
        PagerTabStrip pts_tab = findViewById(R.id.pts_tab);
        // 设置翻页标签栏的文本大小
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        pts_tab.setTextColor(Color.BLACK);
    }

    // 初始化翻页视图
    private void initViewPager() {
        ViewPager vp_content = findViewById(R.id.vp_content);
        mGoodsList = GoodsInfo.getDefaultList();
        MobilePagerAdapter adapter = new MobilePagerAdapter(getSupportFragmentManager(),mGoodsList);
        vp_content.setAdapter(adapter);
        //默认打开第3个
        vp_content.setCurrentItem(3);
    }
}