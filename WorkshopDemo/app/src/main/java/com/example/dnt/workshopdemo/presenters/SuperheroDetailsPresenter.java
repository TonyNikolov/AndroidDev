package com.example.dnt.workshopdemo.presenters;

import com.example.dnt.workshopdemo.PresenterContract;
import com.example.dnt.workshopdemo.ViewContract;
import com.example.dnt.workshopdemo.data.Superhero;
import com.example.dnt.workshopdemo.data.SuperheroDetails;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.R.attr.id;

/**
 * Created by dnt on 6.2.2017 г..
 */

public class SuperheroDetailsPresenter implements PresenterContract.SuperheroDetailsPresenter{

    Retrofit retrofit;
    ViewContract.SuperheroDetailsContract mView;

    @Inject
    SuperheroDetailsPresenter(Retrofit retrofit, ViewContract.SuperheroDetailsContract mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }


    @Override
    public void loadSuperheroeDetailsById(int id) {
        retrofit.create(superheroService.class).getSuperheroById(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<SuperheroDetails>() {

                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(SuperheroDetails superhero) {
                        mView.showSuperheroe(superhero);
                    }
                });
    }


    private interface superheroService {
        @GET("/superheroes/{id}")
        Observable<SuperheroDetails> getSuperheroById(@Path("id") int id);
    }
}
