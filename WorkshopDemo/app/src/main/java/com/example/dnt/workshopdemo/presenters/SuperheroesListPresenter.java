package com.example.dnt.workshopdemo.presenters;

import com.example.dnt.workshopdemo.PresenterContract;
import com.example.dnt.workshopdemo.ViewContract;
import com.example.dnt.workshopdemo.data.Superhero;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dnt on 3.2.2017 г..
 */

public class SuperheroesListPresenter implements PresenterContract.SuperheroesListPresenter {

    Retrofit retrofit;
    ViewContract.SuperheroesList mView;

    @Inject
    SuperheroesListPresenter(Retrofit retrofit, ViewContract.SuperheroesList mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }


    @Override
    public void loadSuperheroes() {
        retrofit.create(superheroService.class).getSuperheroesList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Superhero>>() {

                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Superhero> posts) {
                        mView.showSuperheroes(posts);
                    }
                });
    }


    private interface superheroService {
        @GET("/TonyNikolov/89720ae547e479fb9e92c81ef4b33bef/raw/dcabde67e7fe9032cff702cc24f0cfe208b7402e/superheroes.json")
        Observable<List<Superhero>> getSuperheroesList();
    }
}
