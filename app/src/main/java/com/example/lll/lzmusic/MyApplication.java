package com.example.lll.lzmusic;

import android.app.Application;

/**
 * Created by lll on 2018/6/8.
 */

public class MyApplication extends Application{
   private static MyApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
    }

    public static MyApplication getInstance(){
       return mApplication;
   }
}
