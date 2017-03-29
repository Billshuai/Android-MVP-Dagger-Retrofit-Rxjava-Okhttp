package com.billshuai.tu.di.components;

import com.billshuai.tu.di.modules.SplashModule;
import com.billshuai.tu.di.scopes.UserScope;
import com.billshuai.tu.view.activity.SplashActivity;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by Houge
 */
@UserScope
@Component(modules = SplashModule.class,dependencies = NetComponent.class)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
