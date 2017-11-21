package com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ActivityContext;
import com.example.nazmuddinmavliwala.languagelist.base.views.BaseViewDelegate;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class ErrorViewDelegate extends BaseViewDelegate {

    @Inject
    public ErrorViewDelegate(@NonNull @ActivityContext Context context,
                             @NonNull @Named("Error") View view) {
        super(context, view);
    }
}
