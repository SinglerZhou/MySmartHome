package com.zxg.smarthome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zxg.smarthome.R;
import com.zxg.smarthome.bean.AppDeviceConfig;
import com.zxg.smarthome.bean.DeviceInfoEntry;
import com.zxg.smarthome.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.DeviceViewHolder> {
    Context mContext;
    List<DeviceInfoEntry> mList;

    public DeviceListAdapter(List<DeviceInfoEntry> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View deviceListItemView = LayoutInflater.from(mContext).inflate(R.layout.device_list_item_layout, viewGroup, false);
        return new DeviceViewHolder(deviceListItemView);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int i) {
        holder.mItemTextview.setText(mList.get(i).deviceName);
        holder.mItemTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDeviceConfig.getInstance().setMCurrentDeviceEntry(mList.get(i));
                refreshCurrentDevice(mList.get(i).getDeviceName());
            }
        });
    }

    private void refreshCurrentDevice(String name) {
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setMessage(name);
        EventBus.getDefault().post(messageEvent);
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public class DeviceViewHolder extends RecyclerView.ViewHolder{

        public TextView mItemTextview;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemTextview = itemView.findViewById(R.id.device_list_item_tv);
        }
    }
}
