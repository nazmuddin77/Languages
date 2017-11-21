package com.example.data.network;

import android.support.annotation.NonNull;

import com.example.data.network.converters.GsonResponseBodyConverter;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;

import static java.net.HttpURLConnection.HTTP_MULT_CHOICE;
import static java.net.HttpURLConnection.HTTP_OK;
import static retrofit2.Response.error;
import static retrofit2.Response.success;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class RetrofitManager implements RetrofitService {

    private final RestService restService;
    private final Retrofit retrofit;
    private final Gson gson;

    @Inject
    public RetrofitManager(Retrofit retrofit, Gson gson) {
        this.restService = retrofit.create(RestService.class);
        this.retrofit = retrofit;
        this.gson = gson;
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> get(@NonNull Class<RESPONSE> clazz,
                                                         @NonNull String path,
                                                         @NonNull Map<String, String> queryMap) {
        return this.restService.get(path,queryMap)
                .map(response -> {
                    int status = response.code();
                    if (status >= HTTP_OK && status <= HTTP_MULT_CHOICE) {
                        GsonResponseBodyConverter<RESPONSE> factory
                                = createResponseBodyConverter(clazz);
                        try {
                            RESPONSE genericResponse = factory.convert(response.body());
                            return success(genericResponse, response.raw());
                        } catch (IOException e) {
                            e.printStackTrace();
                            String message = e.getMessage();
                            if (message != null && message.length() > 0) {
                                message = "error: " + message;
                            } else message = "";
                            throw new RuntimeException("error occurred while deserializing " +
                                    "response object : " + clazz.getName() + message);
                        }
                    } else {
                        return error(response.errorBody(), response.raw());
                    }
                });
    }

    private <RESPONSE> GsonResponseBodyConverter<RESPONSE> createResponseBodyConverter(
            Class<RESPONSE> clazz) {
        TypeAdapter<RESPONSE> typeAdapter = gson.getAdapter(clazz);
        return new GsonResponseBodyConverter<>(gson,typeAdapter);
    }
}
