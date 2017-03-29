package com.billshuai.tu.app;

import android.app.Application;
import android.content.Context;


import com.billshuai.tu.di.components.DaggerNetComponent;
import com.billshuai.tu.di.components.NetComponent;
import com.billshuai.tu.di.modules.NetModule;

/**
 * Created by Houge on 2017/3/27.
 */

public class TuApplication extends Application {

    private static TuApplication instance;

    private NetComponent netComponent;

    public static TuApplication get(Context context) {
        return (TuApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initNet();
    }

    private void initNet() {
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public static TuApplication getInstance() {
        return instance;
    }
}
