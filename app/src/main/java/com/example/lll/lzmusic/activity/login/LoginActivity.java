package com.example.lll.lzmusic.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.lll.lzmusic.R;
import com.example.lll.lzmusic.activity.MainActivity;
import com.example.lll.lzmusic.activity.base.BaseActivity;

/**
 * Created by lll on 2018/5/30.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TextInputEditText mUser;
    private TextInputEditText mPsd;
    private TextInputLayout mPsdLayout;
    private Button mLogin;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        mUser = findViewById(R.id.user);
        mPsd = findViewById(R.id.psd);
        mPsdLayout=findViewById(R.id.psdLayout);
        mLogin=findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mPsd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPsdLayout.setErrorEnabled(false);
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                if(!mPsd.getText().toString().equals("123456")){
                    mPsdLayout.setErrorEnabled(true);
                    mPsdLayout.setError("密码错误");
                }
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }

    }
}
