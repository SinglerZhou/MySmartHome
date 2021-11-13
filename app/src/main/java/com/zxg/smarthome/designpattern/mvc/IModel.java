package com.zxg.smarthome.designpattern.mvc;

/**
 * 从Model 抽出来的公共接口
 * @param <T>
 */
public interface IModel<T> {
    void init();

    void setOnStateChangeListener(OnStateChangeListener listener);

    void loadImage();

    void clearImage();

    T getBitmap();
}
