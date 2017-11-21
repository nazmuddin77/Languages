package com.example.domain.interactors;

import com.example.domain.base.Repository;

import rx.Observable;


/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public interface LanguageRepository extends Repository {

    Observable<LanguageResponse> getLanguages(int pageNo);
}
