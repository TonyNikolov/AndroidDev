package com.example.dnt.workshopdemo.main_screen;

import com.example.dnt.workshopdemo.data.NetComponent;
import com.example.dnt.workshopdemo.utils.CustomScope;

import dagger.Component;

import static android.R.attr.fragment;

/**
 * Created by dnt on 3.2.2017 г..
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(AboutFragment fragment);
    void inject(SuperheroesListFragment fragment);
    void inject(SearchFragment fragment);
    void inject(FractionsFragment fragment);


}