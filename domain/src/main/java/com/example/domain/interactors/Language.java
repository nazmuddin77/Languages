package com.example.domain.interactors;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class Language implements LanguageData {

    private final String imageUri;
    private final String name;

    public Language(String imageUri, String name) {
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
