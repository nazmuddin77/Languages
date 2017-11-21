package com.example.data.network;

import android.support.annotation.NonNull;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public interface RestService {

    @GET("{path}")
    Observable<Response<ResponseBody>> get(
            @NonNull @Path("path") String path,
            @NonNull @QueryMap Map<String, String> queryMap
    );
}
