package com.example.nazmuddinmavliwala.languagelist.base.di;

import android.content.Context;

import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ActivityContext;
import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ScopedActivity;
import com.example.nazmuddinmavliwala.languagelist.base.views.BaseActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

@ScopedActivity
@Module
public class BaseActivityModule {

    private BaseActivity activity;

    public BaseActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @ScopedActivity
    @Provides
    @ActivityContext
    public Context provideContext() {
        return this.activity;
    }
}
