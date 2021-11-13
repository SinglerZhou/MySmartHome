package com.zxg.smarthome.designpattern.mvc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.zxg.smarthome.R;

/**
 * MVC中的model，定义具体实现
 */
public class Model implements IModel<Bitmap> {

    private Context mContext;
    private Bitmap mBitmap;
    private OnStateChangeListener mListener; // Model 状态改变监听器

    Handler mHandler = new Handler();
    public Model(Context context) {
        mContext = context;
        // 初始化时预加载一个图片作为默认图
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.image00);
    }

    @Override
    public void init() {

    }

    @Override
    public void setOnStateChangeListener(OnStateChangeListener listener) {
        this.mListener = listener;
    }

    @Override
    public void loadImage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟耗时操作
                    Thread.sleep(3000);

                    //获取图像
                    mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.image01);

                    // 回传给View 子线程给主线程使用handler
                    if (null != mListener) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mListener.onStateChanged(mBitmap);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void clearImage() {
        mBitmap = null; // 清除图片
        if (null != mListener) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mListener.onStateChanged(null);
                }
            });
        }
    }

    @Override
    public Bitmap getBitmap() {
        return mBitmap;
    }
}

