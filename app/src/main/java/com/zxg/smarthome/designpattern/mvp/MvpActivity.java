package com.zxg.smarthome.designpattern.mvp;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zxg.smarthome.R;

import java.util.ArrayList;

public class MvpActivity extends Activity {

    private RecyclerView mMvpRecyclerView;
    private TextView mTextView;
    private ArrayList<String> datas = new ArrayList<>(10);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //After LOLLIPOP not translucent status bar
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //Then call setStatusBarColor.

        // 设置状态栏和导航栏透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        // 设置状态栏和导航栏颜色
//        window.setStatusBarColor(getResources().getColor(R.color.white));
//        window.setNavigationBarColor(getResources().getColor(R.color.transparent));
        setContentView(R.layout.mvp_act_layout);
        initView();
    }

    private void initView() {
        mMvpRecyclerView = findViewById(R.id.mvp_recycler_view);
        mTextView = findViewById(R.id.mvp_text_view);
        if (datas != null) {
            datas.add("京东");
            datas.add("淘宝");
            datas.add("夕夕");
            datas.add("天猫");
            datas.add("抖音");
            datas.add("快手");
        }
        MvpListAdapter mvpListAdapter = new MvpListAdapter(datas);
        mMvpRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMvpRecyclerView.setAdapter(mvpListAdapter);
    }
}
