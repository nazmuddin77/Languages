package com.example.data.repository.converters;

import com.example.data.repository.models.LanguageDO;
import com.example.data.repository.models.LanguageResponseDO;
import com.example.domain.Convertera;
import com.example.domain.interactors.Language;
import com.example.domain.interactors.LanguageResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Converter;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageResponseDODomainConverter implements Convertera<LanguageResponseDO,LanguageResponse> {

    private LanguageDODomainConverter converter;

    @Inject
    public LanguageResponseDODomainConverter(LanguageDODomainConverter converter) {
        this.converter = converter;
    }

    @Override
    public LanguageResponse convert(LanguageResponseDO value) {
        if (value == null) return null;
        List<Language> languages = new ArrayList<>();
        List<LanguageDO> languageDOs = value.getList();
        for (LanguageDO languageDO : languageDOs) {
            languages.add(this.converter.convert(languageDO));
        }
        return new LanguageResponse(value.getTotalPages(),languages);
    }
}
