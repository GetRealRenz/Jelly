package com.test.currency.api;

import com.test.currency.model.Bank;
import com.test.currency.model.BaseResponse;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Антон on 04.04.2016.
 */
public interface ApiService {
    @GET("http://resources.finance.ua/ru/public/currency-cash.json")
    Call<BaseResponse<Bank>>getBanks();
}
