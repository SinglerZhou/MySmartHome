package com.zxg.smarthome.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MainFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;

    public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (mList != null) {
            return mList.get(position);
        } else {
            return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }
}
