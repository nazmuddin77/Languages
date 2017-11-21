package com.example.data.network;

import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class NetworkManager implements NetworkService {

    private RetrofitService service;

    @Inject
    public NetworkManager(RetrofitService service) {
        this.service = service;
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> get(@NonNull Class<RESPONSE> clazz,
                                                         @NonNull String path,
                                                         @NonNull Map<String, String> queryMap) {
        return this.service.get(clazz, path, queryMap);
    }
}
