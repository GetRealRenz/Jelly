package com.test.currency.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Антон on 04.04.2016.
 */
public class CurrencyBase {

    @SerializedName("ask")
    protected double ask;
    @SerializedName("bid")
    protected double dib;

    public double getAsk() {
        return ask;
    }

    public double getDib() {
        return dib;
    }
}
