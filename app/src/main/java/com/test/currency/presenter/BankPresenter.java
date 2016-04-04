package com.test.currency.presenter;

import com.test.currency.App;
import com.test.currency.api.ApiTask;
import com.test.currency.contract.BankContract;
import com.test.currency.model.Bank;
import com.test.currency.model.BaseResponse;

import java.util.List;

import retrofit.Call;

/**
 * Created by Антон on 04.04.2016.
 */
public class BankPresenter implements BankContract.Presenter {
    private BankContract.View mView;
    private Call<BaseResponse<Bank>> mBankCall;

    @Override
    public void initBankList(boolean loadIfEmpty) {
        if(loadIfEmpty)
        fetchBanks();

    }

    @Override
    public void fetchBanks() {
        mBankCall = App.getApiManager().getBanks();
        mBankCall.enqueue(new ApiTask<BaseResponse<Bank>>() {
            @Override
            protected void onSuccess(BaseResponse<Bank> response) {
                mView.showBanks(response.getBanks());
            }
        });
    }

    private void onBanksLoaded() {
        initBankList(false);
    }

    @Override
    public void attachView(BankContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;

    }
}
