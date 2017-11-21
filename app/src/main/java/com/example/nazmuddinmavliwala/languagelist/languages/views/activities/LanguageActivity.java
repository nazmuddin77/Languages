package com.example.nazmuddinmavliwala.languagelist.languages.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.domain.interactors.LanguageData;
import com.example.nazmuddinmavliwala.languagelist.R;
import com.example.nazmuddinmavliwala.languagelist.base.views.BaseActivity;
import com.example.nazmuddinmavliwala.languagelist.base.views.ViewManager;
import com.example.nazmuddinmavliwala.languagelist.languages.di.LanguageModule;
import com.example.nazmuddinmavliwala.languagelist.languages.models.LanguageVO;
import com.example.nazmuddinmavliwala.languagelist.languages.presenter.LanguagePresenter;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates.DataViewDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates.ErrorViewDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates.LoaderViewDelegate;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageActivity extends BaseActivity implements LanguageView {

    @Inject
    ViewManager<List<LanguageData>> viewManager;

    @Inject
    LanguagePresenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_languages;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideLanguageComponent(new LanguageModule(this))
                .inject(this);
        this.viewManager.onCreate();
        this.viewManager.getViewDelegate(DataViewDelegate.class)
                .getNextObservable()
                .subscribe(ignored -> this.presenter.fetchNext());
        this.presenter.fetchLanguages();
    }

    @Override
    public void showLoading() {
        this.viewManager.showExplicit(LoaderViewDelegate.class);
    }

    @Override
    public void hideLoading() {
        this.viewManager.hideSpecific(LoaderViewDelegate.class);
    }

    @Override
    public void showError() {
        this.viewManager.showExplicit(ErrorViewDelegate.class);
    }

    @Override
    public void showDataView() {
        this.viewManager.showExplicit(DataViewDelegate.class);
    }

    @Override
    public void bind(List<LanguageData> viewData) {
        DataViewDelegate viewDelegate = this.viewManager.getViewDelegate(DataViewDelegate.class);
        viewDelegate.bind(viewData);
    }
}
