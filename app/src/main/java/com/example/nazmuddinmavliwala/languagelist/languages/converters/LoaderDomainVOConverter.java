package com.example.nazmuddinmavliwala.languagelist.languages.converters;

import com.example.domain.Convertera;
import com.example.domain.interactors.Loader;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewholders.LoaderVO;

import javax.inject.Inject;


/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LoaderDomainVOConverter implements Convertera<Loader,LoaderVO> {

    @Inject
    public LoaderDomainVOConverter() {
    }

    @Override
    public LoaderVO convert(Loader value) {
        return new LoaderVO();
    }
}
