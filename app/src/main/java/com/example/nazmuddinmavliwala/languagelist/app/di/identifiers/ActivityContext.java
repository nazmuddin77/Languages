package com.example.nazmuddinmavliwala.languagelist.app.di.identifiers;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by nazmuddinmavliwala on 15/04/16.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ActivityContext {
}
