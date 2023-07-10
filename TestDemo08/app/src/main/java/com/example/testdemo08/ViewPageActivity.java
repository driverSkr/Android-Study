package com.example.testdemo08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.testdemo08.adapter.ImagePagerAdapter;
import com.example.testdemo08.entity.GoodsInfo;
import com.example.testdemo08.util.ToastUtil;

import java.util.ArrayList;

/*
* 翻页视图 ViewPager
* */
public class ViewPageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ArrayList<GoodsInfo> mGoodsList;// 手机商品列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        // 从布局视图中获取名叫vp_content的翻页视图
        ViewPager vp_content = findViewById(R.id.vp_content);
        mGoodsList = GoodsInfo.getDefaultList();
        // 构建一个商品图片的翻页适配器
        ImagePagerAdapter adapter = new ImagePagerAdapter(this,mGoodsList);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(0); // 设置翻页视图显示第一页
        //给翻页视图添加页面变更监听器
        vp_content.addOnPageChangeListener(this);
    }

    // 翻页状态改变时触发。state取值说明为：0表示静止，1表示正在滑动，2表示滑动完毕
    // 在翻页过程中，状态值变化依次为：正在滑动→滑动完毕→静止
    @Override
    public void onPageScrollStateChanged(int state) {}

    // 在翻页过程中触发。该方法的三个参数取值说明为 ：第一个参数表示当前页面的序号
    // 第二个参数表示页面偏移的百分比，取值为0到1；第三个参数表示页面的偏移距离
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    // 在翻页结束后触发。position表示当前滑到了哪一个页面
    @Override
    public void onPageSelected(int position) {
        ToastUtil.show(this, "您翻到的手机品牌是：" + mGoodsList.get(position).name);
    }
}