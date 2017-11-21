package com.example.nazmuddinmavliwala.languagelist.languages.views.activities;

import com.example.domain.interactors.LanguageData;
import com.example.nazmuddinmavliwala.languagelist.base.presenters.BaseView;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public interface LanguageView extends BaseView {
    void showError();

    void showDataView();

    void bind(List<LanguageData> viewData);
}
