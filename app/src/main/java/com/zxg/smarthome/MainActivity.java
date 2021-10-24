package com.zxg.smarthome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.zxg.smarthome.adapter.MainFragmentAdapter;
import com.zxg.smarthome.fragment.ContentFragment;
import com.zxg.smarthome.fragment.HomeFragment;
import com.zxg.smarthome.fragment.MallFragment;
import com.zxg.smarthome.fragment.MineFragment;
import com.zxg.smarthome.fragment.SceneFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int TAB_NUM = 5;
    private static final String TAG = MainActivity.class.getCanonicalName();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.main_view_pager);
        mTabLayout = findViewById(R.id.main_tab_layout);

        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected");
                TabLayout.Tab tabAt = mTabLayout.getTabAt(position);
                mTabLayout.selectTab(tabAt);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.selectTab(mTabLayout.getTabAt(2));
    }

    private void initViewPager() {
        // 设置初始化预加载5个pagers
        mViewPager.setOffscreenPageLimit(TAB_NUM);
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new MallFragment());
        mFragmentList.add(new ContentFragment());
        mFragmentList.add(new SceneFragment());
        mFragmentList.add(new MineFragment());
        mViewPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), mFragmentList));
    }
}