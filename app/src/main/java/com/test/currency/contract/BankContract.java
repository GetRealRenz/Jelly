package com.test.currency.contract;

import android.view.View;

import com.test.currency.model.Bank;

import java.util.List;

/**
 * Created by Антон on 04.04.2016.
 */
public class BankContract {

    public interface Presenter extends BasePresenter<View> {
        void initBankList(boolean loadIfEmpty);

        void fetchBanks();
    }

    public interface View extends BaseView {
        void showBanks(List<Bank> bankList);

    }

}
