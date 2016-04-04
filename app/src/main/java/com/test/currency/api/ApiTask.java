package com.test.currency.api;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Антон on 04.04.2016.
 */
public abstract class ApiTask<E> implements Callback<E> {
    @Override
    public void onResponse(Response<E> response, Retrofit retrofit) {
        if (response.isSuccess()) {
            onSuccess(response.body());
        }
    }

    @Override
    public void onFailure(Throwable t) {

    }
    protected abstract void onSuccess(E response);
}
