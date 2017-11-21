package com.example.nazmuddinmavliwala.languagelist.base.di;

import com.example.data.interactors.BackgroundThread;
import com.example.data.interactors.UIThread;
import com.example.domain.executers.ExecutionThread;
import com.example.domain.executers.PostExecutionThread;
import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ScopedActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

@ScopedActivity
@Module
public class RxModule {

    @ScopedActivity
    @Provides
    public ExecutionThread provideExecutionThread(BackgroundThread thread) {
        return thread;
    }

    @ScopedActivity
    @Provides
    public PostExecutionThread providePostExecutionThread(UIThread thread) {
        return thread;
    }
}
