package com.test.currency.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Антон on 04.04.2016.
 */
public class Bank {
    @SerializedName("title")
    private String mTitle;
    private String mId;
    @SerializedName("currencies")
    private Currency currency;

    public String getTitle() {
        return mTitle;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getId() {
        return mId;
    }
}
