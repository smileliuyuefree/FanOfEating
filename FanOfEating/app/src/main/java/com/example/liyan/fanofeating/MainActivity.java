package com.example.liyan.fanofeating;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.liyan.fanofeating.home.interfaces.OnTabReselectListener;
import com.example.liyan.fanofeating.widget.MainTab;
import com.example.liyan.fanofeating.widget.MyFragmentTabHost;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener,View.OnTouchListener{
    private MyFragmentTabHost mTabHost;

    @Override
    public Object getContentResView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mTabHost = ((MyFragmentTabHost) findViewById(android.R.id.tabhost));
    }

    @Override
    public void initData() {
        initTabs();
        setTintResource(R.mipmap.main_head_backgroud);
        showLongToast("标题栏现在是自定义的图片");
    }

    @Override
    public void initListener() {

    }



    private void initTabs() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        if ( android.os.Build.VERSION.SDK_INT > 10 ) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        // 中间按键图片触发
        // mAddBt.setOnClickListener(this);
        mTabHost.setCurrentTab(0);
        mTabHost.setOnTabChangedListener(this);
        MainTab[] tabs = MainTab.values();
        int size = tabs.length;
        for ( int i = 0; i < size; i++ ) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
            View indicator = View.inflate(this, R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            ImageView icon = (ImageView) indicator.findViewById(R.id.iv_icon);

            Drawable drawable = this.getResources().getDrawable(mainTab.getResIcon());
            if ( icon != null ) {
                icon.setImageDrawable(drawable);
            }

            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(indicator);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            mTabHost.addTab(tab, mainTab.getClz(), null);

//            if ( i == 3 ) {
//                View cn = indicator.findViewById(R.id.tab_mes);
//                mBvNotice = new BadgeView(MainActivity.this, cn);
////                mBvNotice.setText("New!");
////                mBvNotice.setText(notifyNum+"");
//
//                mBvNotice.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
//                mBvNotice.setTextSize(TypedValue.COMPLEX_UNIT_SP, 1);
//                mBvNotice.setBackgroundResource(R.drawable.notification_bg);
////                mBvNotice.setBadgeBackgroundColor(Color.RED);
//                mBvNotice.setGravity(Gravity.CENTER);
//                //TODO temporay hide
//                mBvNotice.hide();
//            }
            mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(MainActivity.this);
        }
    }

    @Override
    public void onTabChanged(String s) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean consumed = false;
        if ( event.getAction() == MotionEvent.ACTION_DOWN
                && v.equals(mTabHost.getCurrentTabView()) ) {
            Fragment currentFragment = getCurrentFragment();
            if ( currentFragment != null
                    && currentFragment instanceof OnTabReselectListener) {
                OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
                listener.onTabReselect();
                consumed = true;
            }
        }
        return consumed;
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentByTag(
                mTabHost.getCurrentTabTag());

    }

}
