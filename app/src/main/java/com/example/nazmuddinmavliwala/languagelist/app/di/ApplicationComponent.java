package com.example.nazmuddinmavliwala.languagelist.app.di;

import android.content.Context;


import com.example.data.network.NetworkService;
import com.example.nazmuddinmavliwala.languagelist.app.LanguageListApp;
import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ApplicationContext;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */


@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class
        }
)
public interface ApplicationComponent {

    @ApplicationContext
    Context provideApplicationContext();

    NetworkService provideNetworkService();

    void inject(LanguageListApp app);
}
