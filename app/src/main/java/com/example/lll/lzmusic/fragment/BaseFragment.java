package com.example.lll.lzmusic.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by lll on 2018/6/5.
 */

public class BaseFragment extends Fragment {
    public Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

}
