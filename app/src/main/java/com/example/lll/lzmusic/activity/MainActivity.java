package com.example.lll.lzmusic.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.example.lll.lzmusic.R;
import com.example.lll.lzmusic.activity.base.BaseActivity;
import com.example.lll.lzmusic.util.NavigationViewUtils;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawer;
    private Toolbar mTb;
    private ActionBarDrawerToggle mTog;
    private NavigationView mNv;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mDrawer=findViewById(R.id.drawer);
        mTb = findViewById(R.id.toolbar);
        mTb.setTitle("");
        setSupportActionBar(mTb);
        mTog=new ActionBarDrawerToggle(this,mDrawer,mTb,R.string.app_name,R.string.app_name);
        mDrawer.addDrawerListener(mTog);
        mNv=findViewById(R.id.navigation_view);
        NavigationViewUtils.setNavigationSepHeight(mNv);
        NavigationViewUtils.setNvWidth(mNv);
        NavigationViewUtils.hideScroll(mNv);
    }

    @Override
    protected void initData() {

    }

}
