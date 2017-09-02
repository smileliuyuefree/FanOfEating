package com.example.liyan.fanofeating.tasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.BaseAdapter;

import com.example.liyan.fanofeating.BaseActivity;
import com.example.liyan.fanofeating.R;

/**
 * https://github.com/JetradarMobile/android-snowfall
 */
public class SnowFallActivity extends BaseActivity {

    @Override
    public Object getContentResView() {

        return R.layout.activity_snow_fall;
    }

    @Override
    public void initView() {
        setScreenTransparent();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
