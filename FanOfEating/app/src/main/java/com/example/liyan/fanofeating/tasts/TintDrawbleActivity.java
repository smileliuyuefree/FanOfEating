package com.example.liyan.fanofeating.tasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.liyan.fanofeating.BaseActivity;
import com.example.liyan.fanofeating.R;

public class TintDrawbleActivity extends BaseActivity implements View.OnClickListener{


    private ImageButton mLeft;
    private RelativeLayout mTitleBar;

    @Override
    public void initView() {
        initTitle();
        setTintAlpha();
    }

    private void initTitle() {
        mLeft = ((ImageButton) findViewById(R.id.img_left));
        mTitleBar = ((RelativeLayout) findViewById(R.id.rl_head));
        mTitleBar.setBackgroundResource(R.mipmap.main_head_backgroud);
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
        return R.layout.activity_tint_drawble;
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
