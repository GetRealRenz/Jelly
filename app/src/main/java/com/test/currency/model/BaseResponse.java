package com.test.currency.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Антон on 04.04.2016.
 */
public class BaseResponse<T> {
    @SerializedName("organizations")
    private List<T> mBanks;

    public List<T> getBanks() {
        return mBanks;
    }

    public void setBanks(List<T> mBanks) {
        this.mBanks = mBanks;
    }
}
