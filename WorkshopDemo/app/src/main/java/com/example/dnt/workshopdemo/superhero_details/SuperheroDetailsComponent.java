package com.example.dnt.workshopdemo.superhero_details;

import com.example.dnt.workshopdemo.data.NetComponent;
import com.example.dnt.workshopdemo.main_screen.MainScreenModule;
import com.example.dnt.workshopdemo.utils.CustomScope;

import dagger.Component;

/**
 * Created by dnt on 7.2.2017 г..
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = SuperheroDetailsModule.class)
public interface SuperheroDetailsComponent {
    void inject(SuperheroDetailsFragment detailsFragment);
}
