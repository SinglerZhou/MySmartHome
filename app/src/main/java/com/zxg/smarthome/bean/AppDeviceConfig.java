package com.zxg.smarthome.bean;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 设备信息对象操作的单例类
 */
public class AppDeviceConfig {
    private static final Object LOCK_OBJECT = new Object();

    private static volatile AppDeviceConfig mAppDeviceConfig;

    @Setter
    @Getter
    public List<DeviceInfoEntry> mDeviceInfoEntryList;

    @Setter
    @Getter
    public DeviceInfoEntry mCurrentDeviceEntry;

    public static AppDeviceConfig getInstance() {
        if (mAppDeviceConfig == null) {
            synchronized (LOCK_OBJECT) {
                if (mAppDeviceConfig == null) {
                    mAppDeviceConfig = new AppDeviceConfig();
                }
            }
        }
        return mAppDeviceConfig;
    }

    private AppDeviceConfig() {
    }
}
