package com.example.lll.lzmusic.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lll.lzmusic.R;
import com.example.lll.lzmusic.activity.base.BaseActivity;
import com.example.lll.lzmusic.adapter.MainAdapter;
import com.example.lll.lzmusic.fragment.DiscoverFragment;
import com.example.lll.lzmusic.fragment.FriendFragment;
import com.example.lll.lzmusic.fragment.MusicFragment;
import com.example.lll.lzmusic.fragment.VideoFragment;
import com.example.lll.lzmusic.util.NavigationViewUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {

    private DrawerLayout mDrawer;
    private Toolbar mTb;
    private ActionBarDrawerToggle mTog;
    private NavigationView mNv;
    private ViewPager mVp;
    private List<Fragment> mFragments;
    private Fragment mMusic;
    private Fragment mFriend;
    private Fragment mVideo;
    private Fragment mDiscover;
    private MainAdapter mAdapter;
    private List<ImageView> mIvs;
    private ImageView mIvMusic;
    private ImageView mIvVideo;
    private ImageView mIvDiscover;
    private float downX, moveX;
    private int mCurrentPosition = 0;
    private int mState;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mDrawer = findViewById(R.id.drawer);
        mTb = findViewById(R.id.toolbar);
        mIvMusic = findViewById(R.id.music);
        mIvMusic.setSelected(true);
        mIvMusic.setOnClickListener(this);
        mIvVideo = findViewById(R.id.video);
        mIvVideo.setOnClickListener(this);
        mIvDiscover = findViewById(R.id.discover);
        mIvDiscover.setOnClickListener(this);
        mTb.setTitle("");
        setSupportActionBar(mTb);
        mTog = new ActionBarDrawerToggle(this, mDrawer, mTb, R.string.app_name, R.string.app_name);
        mDrawer.addDrawerListener(mTog);
        mNv = findViewById(R.id.navigation_view);
        NavigationViewUtils.setNavigationSepHeight(mNv);
        NavigationViewUtils.setNvWidth(mNv);
        NavigationViewUtils.hideScroll(mNv);

        mVp = findViewById(R.id.vp);
        mFragments = new ArrayList<Fragment>();
        mMusic = new MusicFragment();
        mDiscover = new DiscoverFragment();
        mVideo = new VideoFragment();
        mFragments.add(mMusic);
        mFragments.add(mVideo);
        mFragments.add(mDiscover);
        mAdapter = new MainAdapter(getSupportFragmentManager(), mFragments);
        mVp.setAdapter(mAdapter);
        mVp.setCurrentItem(mCurrentPosition);
        mVp.setOnTouchListener(this);
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mState == ViewPager.SCROLL_STATE_DRAGGING) {
                    setIconState();
                }
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
                switch (position) {
                    case 0:
                        mIvMusic.setSelected(true);
                        mIvVideo.setSelected(false);
                        mIvDiscover.setSelected(false);
                        break;
                    case 1:
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(true);
                        mIvDiscover.setSelected(false);
                        break;
                    case 2:
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(false);
                        mIvDiscover.setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mState = state;

            }
        });


    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.music:
                mVp.setCurrentItem(0);
                break;
            case R.id.video:
                mVp.setCurrentItem(1);
                break;
            case R.id.discover:
                mVp.setCurrentItem(2);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getX() - downX;
                break;
        }
        return false;
    }
    //设置滑动时顶部图标的状态
    private void setIconState(){
        if ((getWidthPixel() / 2 + Math.abs(moveX)) / getWidthPixel() > 1) {
            switch (mCurrentPosition) {
                case 0:
                    if(moveX>0){
                        mIvMusic.setSelected(true);
                        mIvVideo.setSelected(false);
                        mIvDiscover.setSelected(false);
                    }else{
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(true);
                        mIvDiscover.setSelected(false);
                    }

                    break;
                case 1:
                    if (moveX > 0) {
                        mIvMusic.setSelected(true);
                        mIvVideo.setSelected(false);
                        mIvDiscover.setSelected(false);
                    } else {
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(false);
                        mIvDiscover.setSelected(true);
                    }
                    break;
                case 2:
                    if(moveX>0){
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(true);
                        mIvDiscover.setSelected(false);
                    }else{
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(false);
                        mIvDiscover.setSelected(true);
                    }

                    break;
            }
        } else {
            switch (mCurrentPosition) {
                case 0:
                    mIvMusic.setSelected(true);
                    mIvVideo.setSelected(false);
                    mIvDiscover.setSelected(false);
                    break;
                case 1:
                    if (moveX > 0) {
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(true);
                        mIvDiscover.setSelected(false);
                    } else {
                        mIvMusic.setSelected(false);
                        mIvVideo.setSelected(true);
                        mIvDiscover.setSelected(false);
                    }
                    break;
                case 2:
                    mIvMusic.setSelected(false);
                    mIvVideo.setSelected(false);
                    mIvDiscover.setSelected(true);
                    break;
            }
        }
    }
}
