package com.zxg.smarthome.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zxg.smarthome.R;
import com.zxg.smarthome.bean.AppDeviceConfig;
import com.zxg.smarthome.bean.MessageEvent;
import com.zxg.smarthome.view.DeviceListPopupWindow;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ContentFragment extends Fragment implements View.OnClickListener {

    private TextView mDeviceListText;
    private ImageView mSearchImage;
    private ImageView mSetImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_fragment_layout, container, false);
    }
;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDeviceListText = getActivity().findViewById(R.id.content_fragment_device_list_text);
        mSearchImage = getActivity().findViewById(R.id.content_fragment_search_iv);
        mSetImage = getActivity().findViewById(R.id.content_fragment_set_iv);
        initView();
        initEventBus();
    }

    private void initEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(MessageEvent messageEvent) {
        mDeviceListText.setText(messageEvent.getMessage());
    }

    private void initView() {
        mDeviceListText.setText(AppDeviceConfig.getInstance().getMCurrentDeviceEntry().getDeviceName());
        mDeviceListText.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.content_fragment_device_list_text:
                showPopupWindow();
                break;
            case R.id.content_fragment_search_iv:
                startSearchPage();
                break;
            case R.id.content_fragment_set_iv:
                startSetPage();
                break;
            default:
                break;
        }
    }

    private void startSearchPage() {

    }

    private void startSetPage() {
    }

    private void showPopupWindow() {
        DeviceListPopupWindow deviceListPopupWindow = new DeviceListPopupWindow(getActivity());
        deviceListPopupWindow.showPopupWindow(mDeviceListText);
    }
}
