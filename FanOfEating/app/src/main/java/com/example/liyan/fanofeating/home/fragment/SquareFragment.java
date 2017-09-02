package com.example.liyan.fanofeating.home.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liyan.fanofeating.BaseFragment;
import com.example.liyan.fanofeating.R;
import com.example.liyan.fanofeating.tasts.SnowFallActivity;
import com.example.liyan.fanofeating.tasts.TintColorActivity;

/**
 * author LY
 * create at 2017/8/30.
 */

public class SquareFragment extends BaseFragment implements View.OnClickListener{
    private View view;
    private TextView mGotoSnowFall;

    @Override
    protected void getBundles() {

    }

    @Override
    protected void initData() {
        mGotoSnowFall = ((TextView) view.findViewById(R.id.tv_gotoColor));
        mGotoSnowFall.setOnClickListener(this);

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_square, container, false);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_gotoColor:
                startActivity(new Intent(getContext(), TintColorActivity.class));
                break;
        }
    }
}
