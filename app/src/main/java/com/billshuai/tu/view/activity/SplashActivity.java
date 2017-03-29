package com.billshuai.tu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.billshuai.tu.R;
import com.billshuai.tu.app.TuApplication;
import com.billshuai.tu.di.components.DaggerSplashComponent;
import com.billshuai.tu.di.modules.SplashModule;
import com.billshuai.tu.presenter.SplashContract;
import com.billshuai.tu.presenter.SplashPresenter;
import com.bumptech.glide.Glide;


import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashPresenter presenter;//dagger依赖注解
    private ImageView imageView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv_tu);
        ///特别注意DaggerSplashComponent是Dagger2自动生成的，然后进行注入
        DaggerSplashComponent.builder()
                .netComponent(TuApplication.get(this).getNetComponent())
                .splashModule(new SplashModule(this))
                .build().inject(this);
        presenter.getImage();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Glide.with(SplashActivity.this)
                            .load(url)
                            .into(imageView);
                    break;
            }
        }
    };

    @Override
    public void showLoading() {
    }

    @Override
    public void dismissLoading() {
    }

    @Override
    public void showNoData() {
    }

    @Override
    public void showNoMore() {
    }

    @Override
    public void updateUI(String url) {
        this.url = url;
        Message message = handler.obtainMessage();
        message.what = 1;
        handler.sendMessage(message);

        //两秒后进入主页
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                enterMainActivity();
            }
        }, 2000);
    }

    @Override
    public void showOnFailure() {
    }

    @Override
    public void showLunar(String content) {
    }
    private void enterMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
