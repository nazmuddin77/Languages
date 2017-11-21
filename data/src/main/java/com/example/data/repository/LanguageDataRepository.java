package com.example.data.repository;

import com.example.data.network.NetworkService;
import com.example.data.repository.converters.LanguageResponseDODomainConverter;
import com.example.data.repository.models.LanguageDataDO;
import com.example.data.repository.models.LanguageResponseDO;
import com.example.domain.interactors.LanguageRepository;
import com.example.domain.interactors.LanguageResponse;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageDataRepository implements LanguageRepository {

    private NetworkService service;
    private LanguageResponseDODomainConverter converter;

    @Inject
    public LanguageDataRepository(NetworkService service, LanguageResponseDODomainConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    public Observable<LanguageResponse> getLanguages(int pageNo) {
        String path = "task";
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("page", String.valueOf(pageNo));
        return this.service.get(LanguageDataDO.class,path,hashMap)
                .switchMap(response -> {
                    if (response.isSuccessful()) {
                        LanguageDataDO body = response.body();
                        LanguageResponse languageResponse = this.converter.convert(body.getResponse());
                        return Observable.just(languageResponse);
                    }
                    return Observable.error(NetworkException.createInstance());
                });
    }
}
