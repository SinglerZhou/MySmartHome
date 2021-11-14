package com.zxg.smarthome.designpattern.mvp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.zxg.smarthome.R;

public class MvpNavViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_nav_act_layout);
    }
}
