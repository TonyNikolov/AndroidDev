package com.example.dnt.workshopdemo.main_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dnt.workshopdemo.App;
import com.example.dnt.workshopdemo.ViewContract;

/**
 * Created by dnt on 3.2.2017 г..
 */

public class SearchFragment extends Fragment implements ViewContract.Search {





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        DaggerMainScreenComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showSearch() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }
}
