package com.example.nazmuddinmavliwala.languagelist.languages.di;

import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ChildActivity;
import com.example.nazmuddinmavliwala.languagelist.languages.views.activities.LanguageActivity;

import dagger.Subcomponent;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */


@ChildActivity
@Subcomponent(modules = LanguageModule.class)
public interface LanguageComponent {
    void inject(LanguageActivity activity);
}
