package com.example.dnt.workshopdemo.superhero_details;

import com.example.dnt.workshopdemo.ViewContract;
import com.example.dnt.workshopdemo.utils.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dnt on 7.2.2017 г..
 */
@Module
public class SuperheroDetailsModule {
    ViewContract.SuperheroDetailsContract mSuperheroDetailsView;

    public SuperheroDetailsModule(ViewContract.SuperheroDetailsContract mSuperheroDetailsView){
        this.mSuperheroDetailsView = mSuperheroDetailsView;
    }

    @Provides
    @CustomScope
    ViewContract.SuperheroDetailsContract providesSuperheroDetails() {
        return mSuperheroDetailsView;
    }
}
