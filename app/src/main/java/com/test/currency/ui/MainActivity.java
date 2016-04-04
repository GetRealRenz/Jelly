package com.test.currency.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.test.currency.R;
import com.test.currency.adapters.BankSpinnerAdapter;
import com.test.currency.contract.BankContract;
import com.test.currency.model.Bank;
import com.test.currency.model.EUR;
import com.test.currency.model.RUB;
import com.test.currency.model.USD;
import com.test.currency.presenter.BankPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BankContract.View {

    @Bind(R.id.eur_title)
    TextView eur_title;
    @Bind(R.id.eur_ask)
    TextView eur_ask;
    @Bind(R.id.eur_bid)
    TextView eur_bid;
    @Bind(R.id.usd_title)
    TextView usd_title;
    @Bind(R.id.usd_ask)
    TextView usd_ask;
    @Bind(R.id.usd_bid)
    TextView usd_bid;
    @Bind(R.id.rub_title)
    TextView rub_title;
    @Bind(R.id.rub_ask)
    TextView rub_ask;
    @Bind(R.id.rub_bid)
    TextView rub_bid;


    private BankContract.Presenter mPresenter;
    private BankSpinnerAdapter mBankSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new BankPresenter();
        mPresenter.attachView(this);
        mPresenter.initBankList(true);

    }

    @Override
    public void showBanks(List<Bank> bankList) {
        final Spinner spinner = (Spinner) findViewById(R.id.spinner_categories);
        mBankSpinnerAdapter = new BankSpinnerAdapter(bankList);
        spinner.setAdapter(mBankSpinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Bank selectedBank = mBankSpinnerAdapter.getItem(spinner.getSelectedItemPosition());
                displayCurrencies(selectedBank);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void displayCurrencies(Bank bank) {
        eur_title.setText(EUR.getTITLE());
        eur_ask.setText("Ask " + (bank.getCurrency().getEur().getAsk()));
        eur_bid.setText("Bid " + (bank.getCurrency().getEur().getDib()));

        rub_title.setText(RUB.getTITLE());
        rub_ask.setText("Ask " + (bank.getCurrency().getRub().getAsk()));
        rub_bid.setText("Bid " + (bank.getCurrency().getRub().getDib()));

        usd_title.setText(USD.getTITLE());
        usd_ask.setText("Ask " + (bank.getCurrency().getUsd().getAsk()));
        usd_bid.setText("Bid " + (bank.getCurrency().getUsd().getDib()));
    }

    @Override
    public Context getContext() {
        return null;
    }
}
