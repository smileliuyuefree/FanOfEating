package com.example.liyan.fanofeating.widget;

import com.example.liyan.fanofeating.R;
import com.example.liyan.fanofeating.home.fragment.MineFragment;
import com.example.liyan.fanofeating.home.fragment.PreferenceFragment;
import com.example.liyan.fanofeating.home.fragment.SquareFragment;

public enum MainTab {

    /*
    NEWS(0, R.string.main_tab_name_news, R.drawable.tab_icon_new,
            NewsViewPagerFragment.class),
            */
    //广场
    SQUARE(0, R.string.bottom_square, R.drawable.selecter_square,SquareFragment.class),
    //偏好
    PREFERENCE(1,R.string.bottom_Preference,R.drawable.selecter_preference,PreferenceFragment.class),
    MINE(2,R.string.bottom_mine,R.drawable.selecter_mine,MineFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
