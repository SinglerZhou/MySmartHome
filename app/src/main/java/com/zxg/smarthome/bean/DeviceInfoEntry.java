package com.zxg.smarthome.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DeviceInfoEntry {
    public String deviceName;
    public String deviceId;
    public String iotId;
    public String xinDeviceId;
    public String thirdDeviceId;
}
