package com.example.dnt.workshopdemo;

import com.example.dnt.workshopdemo.data.Fraction;
import com.example.dnt.workshopdemo.data.Superhero;

import java.util.List;

/**
 * Created by dnt on 3.2.2017 г..
 */

public interface ViewContract {
    interface SuperheroesList {
        void showSuperheroes(List<Superhero> superheros);

        void showError(String message);

        void showComplete();
    }

    interface FractionList {
        void showSuperheroes(List<Fraction> fractions);

        void showError(String message);

        void showComplete();
    }

    interface Tabs{

        void showTabs();

        void showError(String message);

        void showComplete();
    }

    interface About{

        void showAbout();

        void showError(String message);

        void showComplete();
    }

    interface Search{

        void showSearch();

        void showError(String message);

        void showComplete();
    }


}
