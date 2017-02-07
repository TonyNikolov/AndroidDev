package com.example.dnt.workshopdemo;

import java.util.List;

/**
 * Created by dnt on 3.2.2017 г..
 */

public interface PresenterContract {

    interface SuperheroesListPresenter {
        void loadSuperheroes();
    }

    interface SuperheroDetailsPresenter{
        void loadSuperheroeDetailsById(int id);
    }

    interface FractionsListPresenter{
        void loadFractions();

    }


    interface TabsPresenter {
        void loadTabs();
    }

    interface AboutPresenter{
        void loadInfo();
    }

    interface SearchPresenter{
        void searchSuperheroByName();
    }
}
