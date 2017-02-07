package com.example.dnt.workshopdemo.main_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dnt.workshopdemo.App;
import com.example.dnt.workshopdemo.R;
import com.example.dnt.workshopdemo.ViewContract;
import com.example.dnt.workshopdemo.data.Superhero;
import com.example.dnt.workshopdemo.data.superheroAdapter;
import com.example.dnt.workshopdemo.presenters.SuperheroesListPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by dnt on 3.2.2017 г..
 */

public class SuperheroesListFragment extends Fragment implements ViewContract.SuperheroesList {

    RecyclerView recyclerView;
    ArrayList<Superhero> list;
    superheroAdapter adapter;

    @Inject
    SuperheroesListPresenter presenter;

    public SuperheroesListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.superheroes_list_fragment, container, false);
        DaggerMainScreenComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        this.list = new ArrayList<>();
        this.presenter.loadSuperheroes();
        recyclerView = (RecyclerView) view.findViewById(R.id.my_list);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        return view;
    }

    @Override
    public void showSuperheroes(List<Superhero> superheros) {
        for (int i = 0; i < superheros.size(); i++) {
            this.list.add(superheros.get(i));
        }

        adapter = new superheroAdapter(getActivity(), this.list);
        recyclerView.setAdapter(adapter);

        //method complete
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), "Error" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getContext(), "Complete", Toast.LENGTH_SHORT).show();
    }
}
