package com.zxg.smarthome.designpattern.mvc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.zxg.smarthome.R;

/**
 * 类似Control
 */
public class MvcActivity extends Activity implements View.OnClickListener {

    private ImageView mImageView;
    private Button mLoadButton;
    private Button mClearButton;
    private Model mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvc_layout);
        mModel = new Model(this);
        initModel();
        init();
    }

    private void initModel() {
        mModel.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChanged(Bitmap bitmap) {
                if (mImageView != null) {
                    mImageView.setImageBitmap(bitmap);
                }
            }
        });
    }

    private void init() {
        mImageView = findViewById(R.id.mvc_image_view);
        mLoadButton = findViewById(R.id.mvc_load_button);
        mClearButton = findViewById(R.id.mvc_clear_button);

        mImageView.setImageBitmap(mModel.getBitmap());

        mClearButton.setOnClickListener(this);
        mLoadButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mvc_load_button:
                mModel.loadImage();
                break;
            case R.id.mvc_clear_button:
                mModel.clearImage();
                break;
            default:
                break;
        }
    }
}
