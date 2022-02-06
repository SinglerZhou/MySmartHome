package com.zxg.smarthome.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zxg.smarthome.R;
import com.zxg.smarthome.adapter.DeviceListAdapter;
import com.zxg.smarthome.bean.AppDeviceConfig;

public class DeviceListPopupWindow extends PopupWindow {
    @SuppressLint("UseCompatLoadingForDrawables")
    public DeviceListPopupWindow(Activity activity) {
        super(activity);
        View popupWindow = LayoutInflater.from(activity)
                .inflate(R.layout.device_list_popup_window_layout, null);
        this.setContentView(popupWindow);
        initView(popupWindow, activity);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.ic_launcher_background));

    }

    private void initView(View view, Activity activity) {
        RecyclerView popupRecyclerView = view.findViewById(R.id.device_list_popup_recycler_view);
        popupRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        popupRecyclerView.setAdapter(new DeviceListAdapter(
                AppDeviceConfig.getInstance().getMDeviceInfoEntryList(), activity));

    }

    public void showPopupWindow(TextView deviceListText) {
        this.showAsDropDown(deviceListText);
    }
}
