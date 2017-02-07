package com.example.dnt.workshopdemo.presenters;

import com.example.dnt.workshopdemo.PresenterContract;
import com.example.dnt.workshopdemo.ViewContract;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by dnt on 3.2.2017 г..
 */

public class TabsFragmentPresenter implements PresenterContract.TabsPresenter {
    Retrofit retrofit;
    ViewContract.Tabs mTabsView;

    @Inject
    TabsFragmentPresenter(Retrofit retrofit, ViewContract.Tabs mTabsView) {
        this.retrofit = retrofit;
        this.mTabsView = mTabsView;
    }

    @Override
    public void loadTabs() {
        //TODO


    }

}
