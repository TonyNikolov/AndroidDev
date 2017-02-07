package com.example.dnt.workshopdemo.presenters;

import com.example.dnt.workshopdemo.PresenterContract;
import com.example.dnt.workshopdemo.ViewContract;
import com.example.dnt.workshopdemo.data.Fraction;
import com.example.dnt.workshopdemo.data.Superhero;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dnt on 6.2.2017 г..
 */

public class FractionsListPresenter implements PresenterContract.FractionsListPresenter{

    Retrofit retrofit;
    ViewContract.FractionList mView;

    @Inject
    FractionsListPresenter(Retrofit retrofit, ViewContract.FractionList mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadFractions() {
        retrofit.create(fractionsService.class).getFractionList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Fraction>>() {

                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Fraction> posts) {
                        mView.showFractions(posts);
                    }
                });
    }


    private interface fractionsService {
        @GET("/fractions")
        Observable<List<Fraction>> getFractionList();
    }
}
