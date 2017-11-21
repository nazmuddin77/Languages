package com.example.data.repository;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class NetworkException extends Throwable {

    public static NetworkException createInstance() {
        return new NetworkException();
    }
}
