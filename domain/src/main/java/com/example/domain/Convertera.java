package com.example.domain;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public interface Convertera<FROM,TO> {

    public TO convert(FROM data);
}
