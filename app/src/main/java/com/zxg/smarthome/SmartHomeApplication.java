package com.zxg.smarthome;

import android.app.Application;

import com.zxg.smarthome.bean.AppDeviceConfig;
import com.zxg.smarthome.bean.DeviceInfoEntry;

import java.util.ArrayList;

public class SmartHomeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData() {
        ArrayList<DeviceInfoEntry> deviceInfoEntries = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DeviceInfoEntry deviceInfoEntry = new DeviceInfoEntry();
            deviceInfoEntry.setDeviceName("新贵的音箱 " + "-家" + i);
            deviceInfoEntry.setDeviceId(i + 111110 + "");
            deviceInfoEntry.setIotId(i + 222220 + "");
            deviceInfoEntry.setXinDeviceId(i + 333330 + "");
            deviceInfoEntry.setThirdDeviceId(i + 444440 + "");
            deviceInfoEntries.add(deviceInfoEntry);
        }
        AppDeviceConfig.getInstance().setMDeviceInfoEntryList(deviceInfoEntries);
        AppDeviceConfig.getInstance().setMCurrentDeviceEntry(deviceInfoEntries.get(0));
    }
}
