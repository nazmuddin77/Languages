package com.example.nazmuddinmavliwala.languagelist.languages.di;

import android.view.View;

import com.example.data.repository.LanguageDataRepository;
import com.example.data.repository.converters.LanguageDODomainConverter;
import com.example.domain.interactors.LanguageData;
import com.example.domain.interactors.LanguageRepository;
import com.example.nazmuddinmavliwala.languagelist.R;
import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ChildActivity;
import com.example.nazmuddinmavliwala.languagelist.base.views.ViewDelegate;
import com.example.nazmuddinmavliwala.languagelist.base.views.ViewManager;
import com.example.nazmuddinmavliwala.languagelist.languages.views.activities.LanguageActivity;
import com.example.nazmuddinmavliwala.languagelist.languages.views.activities.LanguageView;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates.DataViewDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates.ErrorViewDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates.LoaderViewDelegate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */


@ChildActivity
@Module
public class LanguageModule {

    private LanguageActivity activity;

    public LanguageModule(LanguageActivity activity) {
        this.activity = activity;
    }

    @ChildActivity
    @Provides
    public LanguageRepository provideRepo(LanguageDataRepository repository) {
        return repository;
    }

    @ChildActivity
    @Provides
    @Named("Data")
    public View provideDataView() {
        return this.activity.findViewById(R.id.v_data);
    }

    @ChildActivity
    @Provides
    @Named("Error")
    public View provideErrorView() {
        return this.activity.findViewById(R.id.v_error);
    }

    @ChildActivity
    @Provides
    @Named("Loader")
    public View provideLoaderView() {
        return this.activity.findViewById(R.id.v_loader);
    }

    @ChildActivity
    @Provides
    public ViewManager<List<LanguageData>> provideViewManager(LoaderViewDelegate loaderViewDelegate,
                                                              ErrorViewDelegate errorViewDelegate,
                                                              DataViewDelegate dataViewDelegate) {
        List<ViewDelegate<List<LanguageData>>> viewDelegates = new ArrayList<>();
        viewDelegates.add(loaderViewDelegate);
        viewDelegates.add(errorViewDelegate);
        viewDelegates.add(dataViewDelegate);
        return new ViewManager<>(viewDelegates);
    }

    @ChildActivity
    @Provides
    public LanguageView provideView() {
        return this.activity;
    }
}
