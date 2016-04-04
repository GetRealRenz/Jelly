package com.test.currency.api;

import android.content.Context;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.test.currency.model.Bank;
import com.test.currency.model.BaseResponse;

import java.io.IOException;


import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Антон on 04.04.2016.
 */
public class ApiManager implements Manager {
    private ApiService mApiService;
    private Retrofit mRetrofit;

    @Override
    public void init(Context context) {
        initRetrofit();
        initServices();
    }

    @Override
    public void clear() {

    }


    private void initRetrofit() {
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request orginal = chain.request();
                Request request = orginal.newBuilder()
                        .method(orginal.method(), orginal.body())
                        .build();
                return chain.proceed(request);
            }
        });
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(interceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://resources.finance.ua/ru/public/currency-cash.json")
                .addConverterFactory(createGsonConverter())
                .client(client)
                .build();
    }

    private void initServices() {
        mApiService = mRetrofit.create(ApiService.class);
    }

    private GsonConverterFactory createGsonConverter() {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        builder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        return GsonConverterFactory.create(builder.create());
    }

    public Call<BaseResponse<Bank>> getBanks() {
        return mApiService.getBanks();
    }
}
