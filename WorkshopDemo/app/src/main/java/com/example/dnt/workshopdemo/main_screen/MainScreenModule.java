package com.example.dnt.workshopdemo.main_screen;

import android.view.View;

import com.example.dnt.workshopdemo.ViewContract;
import com.example.dnt.workshopdemo.utils.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dnt on 3.2.2017 г..
 */

@Module
public class MainScreenModule {
    private ViewContract.Tabs mTabsView;
    private ViewContract.SuperheroesList mBooksListView;
    private ViewContract.Search mSearchView;
    private ViewContract.About mAboutView;
    private ViewContract.FractionList mFractionsView;

    public MainScreenModule(ViewContract.FractionList mFractionsView){
        this.mFractionsView = mFractionsView;
    }

//    public MainScreenModule(ViewContract.Tabs mTabsView) {
//
//        this.mTabsView = mTabsView;
//    }

    public MainScreenModule(ViewContract.SuperheroesList mBooksListView) {

        this.mBooksListView = mBooksListView;
    }

    public MainScreenModule(ViewContract.Search mSearchView) {

        this.mSearchView = mSearchView;
    }

//    public MainScreenModule(ViewContract.About mAboutView) {
//
//        this.mAboutView = mAboutView;
//    }

    @Provides
    @CustomScope
    ViewContract.Tabs providesMainScreenViewContractTabs() {
        return mTabsView;
    }

    @Provides
    @CustomScope
    ViewContract.SuperheroesList providesMainScreenViewContractBooksList() { return mBooksListView;}

    @Provides
    @CustomScope
    ViewContract.Search providesMainScreenViewContractSearch() {
        return mSearchView;
    }

    @Provides
    @CustomScope
    ViewContract.About providesMainScreenViewContractAbout() {
        return mAboutView;
    }

    @Provides
    @CustomScope
    ViewContract.FractionList providesMainScreenViewContractFractionsList(){return mFractionsView;}

}
