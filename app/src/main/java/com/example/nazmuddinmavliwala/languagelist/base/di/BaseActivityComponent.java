package com.example.nazmuddinmavliwala.languagelist.base.di;

import android.content.Context;

import com.example.data.network.NetworkService;
import com.example.domain.executers.ExecutionThread;
import com.example.domain.executers.PostExecutionThread;
import com.example.nazmuddinmavliwala.languagelist.app.di.ApplicationComponent;
import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ActivityContext;
import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ScopedActivity;
import com.example.nazmuddinmavliwala.languagelist.base.views.BaseActivity;
import com.example.nazmuddinmavliwala.languagelist.languages.di.LanguageComponent;
import com.example.nazmuddinmavliwala.languagelist.languages.di.LanguageModule;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

@ScopedActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                BaseActivityModule.class,
                RxModule.class,
        }
)
public interface BaseActivityComponent {

    @ActivityContext
    Context provideActivityContext();

    ExecutionThread provideExecutionThread();

    PostExecutionThread providePostExecutionThread();

    NetworkService provideNetworkService();

    void inject(BaseActivity activity);

    LanguageComponent provideLanguageComponent(LanguageModule module);
}
