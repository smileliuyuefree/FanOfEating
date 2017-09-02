package com.example.liyan.fanofeating.home.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liyan.fanofeating.BaseFragment;
import com.example.liyan.fanofeating.R;
import com.example.liyan.fanofeating.tasts.TintDrawbleActivity;

/**
 * author LY
 * create at 2017/8/31.
 */

public class PreferenceFragment extends BaseFragment implements View.OnClickListener{
    private View view;
    private TextView mGoToDrawble;

    @Override
    protected void getBundles() {

    }

    @Override
    protected void initData() {
        mGoToDrawble = ((TextView) view.findViewById(R.id.tv_gotoDrable));
        mGoToDrawble.setOnClickListener(this);

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_preference,container,false);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_gotoDrable:
                startActivity(new Intent(getContext(), TintDrawbleActivity.class));
                break;
        }

    }
}
