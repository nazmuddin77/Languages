package com.example.domain.interactors;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageResponse {

    private final int totalPages;
    private final List<Language> languages;

    public LanguageResponse(int totalPages, List<Language> languages) {
        this.totalPages = totalPages;
        this.languages = languages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
