package com.example.nazmuddinmavliwala.languagelist.languages.models;

import com.example.domain.interactors.LanguageData;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageVO implements LanguageData {

    private final String imageUri;
    private final String name;

    public LanguageVO(String imageUri, String name) {
        this.imageUri = imageUri;
        this.name = name;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getName() {
        return name;
    }
}
