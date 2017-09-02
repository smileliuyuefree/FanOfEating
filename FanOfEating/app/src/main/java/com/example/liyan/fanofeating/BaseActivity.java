package com.example.liyan.fanofeating;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.liyan.fanofeating.utils.SystemBarTintManager;

/**
 * author LY
 * create at 2017/8/31.
 *
 * https://github.com/rejasupotaro/MaterialDesignSample
 */

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 上下文
     **/
    protected Activity mActivity;
    /**
     * 初始化
     **/
    public abstract void initView();
    public abstract void initData();
    public abstract void initListener();

    /**
     * 获取view布局,只支持int和view
     */
    public abstract Object getContentResView();

    /**
     * 沉浸模式
     */
    protected SystemBarTintManager mTintManager;
    /**
     * 页面关闭动画
     */
    private boolean isAnimFinish = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        Object o = getContentResView();
        if (o instanceof Integer) {
            setContentView((Integer) o);
        } else if (o instanceof View) {
            setContentView((View) o);
        } else {
            throw new IllegalStateException(
                    "getContentResView返回不是integer或者view类型");
        }
        initView();
        initData();
        initListener();
    }
    /**
     * 沉浸式设置
     * author LY
     * create at 2017/8/31 15:31
     */
    private void setTint() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        if(mTintManager == null) {
            mTintManager = new SystemBarTintManager(this);
        }
        mTintManager.setStatusBarTintEnabled(true);
    }

    /**
     * 状态栏透明 利用背景图片可使得状态栏随背景图片变化而变化
     * author LY
     * create at 2017/8/31 15:34
     */
    public void setTintAlpha() {
        setTint();
        mTintManager.setStatusBarAlpha(0.0f);
    }

    /**
     * 自定义状态栏颜色
     * author LY
     * create at 2017/8/31 15:33
     * color-----Color.parseColor("#333")
     */
    public void setTintColor(int color) {
        setTint();
        mTintManager.setStatusBarTintColor(color);
    }

    /**
     * 自定义状态栏图片
     * author LY
     * create at 2017/8/31 15:28
     * mipmap------R.mipmap.ic_lancher
     */
    public void setTintResource(int mipmap){
        setTint();
        mTintManager.setStatusBarTintResource(mipmap);
    }

    /**
     * 设置全屏--隐藏状态栏
     * author LY
     * create at 2017/8/31 18:10
     *
     */
    public void setFullScreen(){
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 设置透明状态栏和通知栏
     * author LY
     * create at 2017/8/31 19:08
     */
    public void setScreenTransparent(){

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = this.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            this.getWindow().setNavigationBarColor(Color.TRANSPARENT);
            this.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * 沉浸模式 设置沉浸式状态栏
     * author LY
     * create at 2017/8/31 16:27
     */
    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * 短toast
     * author LY
     * @param str 要toast的文字
     */
    public void showShortToast(int str){
        Toast toast = Toast.makeText(this,str,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER , 0, 0);
        toast.show();
    }
    /**
     * 屏幕中间弹出的短toast
     * author LY
     * @param str 要toast的文字
     */
    public void showShortToast(String str){
        Toast  toast = Toast.makeText(this,str,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER , 0, 0);
        toast.show();
    }

    /**
     * 屏幕中间弹出的长toast
     * author LY
     * @param str 要toast的文字
     */
    public void showLongToast(int str){
        Toast  toast = Toast.makeText(this,str,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER , 0, 0);
        toast.show();
    }

    /**
     * 屏幕中间弹出的长toast
     * author LY
     * @param str 要toast的文字
     */
    public void showLongToast(String str){
        Toast  toast = Toast.makeText(this,str,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER , 0, 0);
        toast.show();
    }

    /**
     * false 淡入启动Activity
     *
     * @param intent
     * @param anim
     */
    public void startActivity(Intent intent, boolean anim) {
        if (anim) {
            startActivity(intent);
        } else {
            super.startActivity(intent);
            overridePendingTransition(R.anim.alpha_out, R.anim.alpha_in);
        }
    }

    /**
     * 打开activity执行的方法
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_none);
    }

    /**
     * 关闭执行的动画
     */
    @Override
    public void finish() {
        super.finish();
//        KeyBoardUtils.hideSoftInput(this);
        if (isAnimFinish) {
            overridePendingTransition(R.anim.push_none, R.anim.push_up_out);
        }
    }

    /**
     * 可以设置关闭退出动画
     *
     * @param isAnimFinish
     */
    public void setAnimFinish(boolean isAnimFinish) {
        this.isAnimFinish = isAnimFinish;
    }
}
