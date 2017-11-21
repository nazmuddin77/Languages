package com.example.nazmuddinmavliwala.languagelist.languages.presenter;

import com.example.domain.interactors.Language;
import com.example.domain.interactors.LanguageData;
import com.example.domain.interactors.LanguageUseCase;
import com.example.domain.interactors.Loader;
import com.example.nazmuddinmavliwala.languagelist.base.presenters.BasePresenter;
import com.example.nazmuddinmavliwala.languagelist.languages.converters.LanguageDomainVOConverter;
import com.example.nazmuddinmavliwala.languagelist.languages.converters.LoaderDomainVOConverter;
import com.example.nazmuddinmavliwala.languagelist.languages.views.activities.LanguageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguagePresenter extends BasePresenter<LanguageView> {

    private final LanguageUseCase useCase;
    private final LanguageDomainVOConverter languageDomainVOConverter;
    private final LoaderDomainVOConverter loaderDomainVOConverter;

    @Inject
    public LanguagePresenter(LanguageView view,
                             LanguageUseCase useCase,
                             LanguageDomainVOConverter languageDomainVOConverter,
                             LoaderDomainVOConverter loaderDomainVOConverter) {
        super(view);
        this.useCase = useCase;
        this.languageDomainVOConverter = languageDomainVOConverter;
        this.loaderDomainVOConverter = loaderDomainVOConverter;
    }

    public void fetchLanguages() {
        view.showLoading();
        this.useCase.getLanguages(new Subscriber<List<LanguageData>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.hideLoading();
                view.showError();
            }

            @Override
            public void onNext(List<LanguageData> languageData) {
                view.hideLoading();
                view.showDataView();
                List<LanguageData> viewData = new ArrayList<>();
                for (LanguageData l : languageData) {
                    if (l instanceof Language) {
                        viewData.add(languageDomainVOConverter.convert((Language) l));
                    } else {
                        viewData.add(loaderDomainVOConverter.convert((Loader) l));
                    }
                }
                view.bind(viewData);
            }
        });
    }

    public void fetchNext() {
        this.useCase.nextPage();
    }
}
