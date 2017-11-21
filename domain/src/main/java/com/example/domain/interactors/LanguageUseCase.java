package com.example.domain.interactors;

import com.example.domain.base.Pager;
import com.example.domain.base.UseCase;
import com.example.domain.executers.ExecutionThread;
import com.example.domain.executers.PostExecutionThread;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageUseCase extends UseCase<LanguageRepository> {

    private int currentPage = 0;

    private final Pager<LanguageResponse,List<LanguageData>> pager;

    @Inject
    public LanguageUseCase(ExecutionThread executionThread,
                           PostExecutionThread postExecutionThread,
                           LanguageRepository repository) {
        super(executionThread, postExecutionThread, repository);
        Pager.PagingFunction<LanguageResponse> pagingFunction = languageResponse -> {
            if (currentPage < languageResponse.getTotalPages())
                return repository.getLanguages(currentPage + 1)
                .compose(applySchedulers());
            else return Pager.finish();
        };

        Func1<LanguageResponse,List<LanguageData>> func1 = languageResponse -> {
            List<LanguageData> languageData = new ArrayList<>();
            languageData.addAll(languageResponse.getLanguages());
            if (currentPage < languageResponse.getTotalPages()) {
                currentPage++;
                languageData.add(new Loader());
            }
            return languageData;
        };
        this.pager = Pager.create(pagingFunction,func1);
    }

    public void getLanguages(Subscriber<List<LanguageData>> subscriber) {
        Observable<LanguageResponse> ob = this.repository.getLanguages(++currentPage)
                .compose(applySchedulers());
        this.pager.page(ob).subscribe(subscriber);
    }

    public void nextPage() {
        this.pager.next();
    }
}
