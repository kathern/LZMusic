package com.example.lll.lzmusic.util;

import android.app.Application;
import android.content.Context;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.lll.lzmusic.MyApplication;
import com.example.lll.lzmusic.R;

import java.lang.reflect.Field;

/**
 * Created by lll on 2018/6/8.
 */

public class NavigationViewUtils {
    private static int height = 20;

    /**
     * 设置NavigationSeperator高度
     */
    public static void setNavigationSepHeight(NavigationView nv){
        try {
            Field fieldPresenter = nv.getClass().getDeclaredField("mPresenter");
            fieldPresenter.setAccessible(true);
            NavigationMenuPresenter  menuPresenter = (NavigationMenuPresenter) fieldPresenter.get(nv);
            Field fieldMenuView= menuPresenter.getClass().getDeclaredField("mMenuView");
            fieldMenuView.setAccessible(true);
            final NavigationMenuView menuView = (NavigationMenuView) fieldMenuView.get(menuPresenter);
            menuView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
                @Override
                public void onChildViewAttachedToWindow(View view) {
                    RecyclerView.ViewHolder holder=menuView.getChildViewHolder(view);
                    if(holder!=null&&holder.itemView!=null&&"SeparatorViewHolder".equals(holder.getClass().getSimpleName())){
                        if(holder.itemView instanceof FrameLayout){
                            FrameLayout frame= (FrameLayout) holder.itemView;
                            View line =frame.getChildAt(0);
                            line.getLayoutParams().height=height;
                            line.setLayoutParams(line.getLayoutParams());
                        }
                    }
                }

                @Override
                public void onChildViewDetachedFromWindow(View view) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //设置侧滑菜单栏宽度
    public static void setNvWidth(NavigationView nv){
        ViewGroup.LayoutParams params = nv.getLayoutParams();
        params.width = MyApplication.getInstance().getResources().getDisplayMetrics().widthPixels*5/6;
        nv.setLayoutParams(params);
    }

    //取消滚动条显示
    public static void hideScroll(NavigationView nv){
        NavigationMenuView menuView = (NavigationMenuView) nv.getChildAt(0);
        if(menuView!=null){
            menuView.setVerticalScrollBarEnabled(false);
        }
    }

    public static void setTabIndicator(TabLayout tabLayout){
        try {
            Field tab=tabLayout.getClass().getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
