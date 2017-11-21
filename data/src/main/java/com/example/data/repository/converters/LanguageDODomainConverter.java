package com.example.data.repository.converters;

import com.example.data.repository.models.LanguageDO;
import com.example.domain.Convertera;
import com.example.domain.interactors.Language;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Converter;


/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageDODomainConverter implements Convertera<LanguageDO, Language> {

    @Inject
    public LanguageDODomainConverter() {
    }

    @Override
    public Language convert(LanguageDO value)  {
        if (value == null) return null;
        return new Language(value.getIcon(),value.getName());
    }
}
