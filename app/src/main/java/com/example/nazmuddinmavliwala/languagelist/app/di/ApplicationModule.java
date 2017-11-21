package com.example.nazmuddinmavliwala.languagelist.app.di;

import android.app.Application;
import android.content.Context;

import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ApplicationContext;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */


@Singleton
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @ApplicationContext
    @Provides
    public Context getContext() {
        return this.application;
    }
}
