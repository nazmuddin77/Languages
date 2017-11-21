package com.example.data.network;

import android.support.annotation.NonNull;

import java.util.Map;

import retrofit2.Response;
import rx.Observable;


/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public interface NetworkService {

    <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap
    );

}
