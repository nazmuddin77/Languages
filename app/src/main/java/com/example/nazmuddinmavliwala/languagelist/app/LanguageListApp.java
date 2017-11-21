package com.example.nazmuddinmavliwala.languagelist.app;

import android.app.Application;

import com.example.nazmuddinmavliwala.languagelist.app.di.ApplicationComponent;
import com.example.nazmuddinmavliwala.languagelist.app.di.ApplicationModule;
import com.example.nazmuddinmavliwala.languagelist.app.di.DaggerApplicationComponent;
import com.example.nazmuddinmavliwala.languagelist.app.di.DataModule;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

public class LanguageListApp extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .build();
        component.inject(this);
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
