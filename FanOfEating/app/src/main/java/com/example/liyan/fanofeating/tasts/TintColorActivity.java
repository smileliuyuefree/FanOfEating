package com.example.liyan.fanofeating.tasts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liyan.fanofeating.BaseActivity;
import com.example.liyan.fanofeating.R;

public class TintColorActivity extends BaseActivity implements View.OnClickListener{


    private ImageButton mLeft;
    private RelativeLayout mTitleBar;
    private TextView mTitle;

    @Override
    public void initView() {
        initTitle();
        setTintColor(Color.parseColor("#FF0000"));
    }

    private void initTitle() {
        mLeft = ((ImageButton) findViewById(R.id.img_left));
        mTitleBar = ((RelativeLayout) findViewById(R.id.rl_head));
        mTitle = ((TextView) findViewById(R.id.jc_tv_title));
        mTitle.setText("颜色沉浸");
        mTitleBar.setBackgroundColor(Color.parseColor("#FF0000"));
        mLeft.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public Object getContentResView() {
        return R.layout.activity_tint_color;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_left:
                finish();
                break;
        }
    }
}
