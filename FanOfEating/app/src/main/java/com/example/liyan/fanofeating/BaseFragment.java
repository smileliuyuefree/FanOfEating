package com.example.liyan.fanofeating;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LY on 2016/7/6.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater,container);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBundles();
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    protected abstract void getBundles();

    //初始化数据，由子类实现
    protected abstract void initData();

    //初始化布局，由子类实现
    public abstract View initView(LayoutInflater inflater, ViewGroup container);
}
