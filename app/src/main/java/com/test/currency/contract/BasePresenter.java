package com.test.currency.contract;

/**
 * Created by Антон on 04.04.2016.
 */
public interface BasePresenter<V extends BaseView > {

    void attachView(V view);

    void detachView();
}
