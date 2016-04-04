package com.test.currency.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Антон on 04.04.2016.
 */
public class Currency {
    @SerializedName("EUR")
    private EUR eur;
    @SerializedName("USD")
    private USD usd;
    @SerializedName("RUB")
    private RUB rub;

    public EUR getEur() {
        return eur;
    }

    public USD getUsd() {
        return usd;
    }

    public RUB getRub() {
        return rub;
    }
}
