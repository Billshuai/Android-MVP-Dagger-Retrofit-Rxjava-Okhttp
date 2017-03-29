package com.billshuai.tu.di.modules;


import com.billshuai.tu.presenter.SplashContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Houge

 */
@Module
public class SplashModule {
    private SplashContract.View view;

    public SplashModule(SplashContract.View view) {
        this.view = view;
    }
    @Provides
    public SplashContract.View provideView(){
        return view;
    }
}
