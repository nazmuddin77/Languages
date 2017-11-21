package com.example.nazmuddinmavliwala.languagelist.languages.converters;

import com.example.domain.Convertera;
import com.example.domain.interactors.Language;
import com.example.nazmuddinmavliwala.languagelist.languages.models.LanguageVO;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Converter;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageDomainVOConverter implements Convertera<Language,LanguageVO> {

    @Inject
    public LanguageDomainVOConverter() {
    }

    @Override
    public LanguageVO convert(Language value)  {
        if (value == null) return null;
        return new LanguageVO(value.getImageUri(),value.getName());
    }
}
