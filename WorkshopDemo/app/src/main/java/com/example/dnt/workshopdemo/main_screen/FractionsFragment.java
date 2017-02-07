package com.example.dnt.workshopdemo.main_screen;

import android.content.Context;
import android.net.Uri;
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
import com.example.dnt.workshopdemo.data.Fraction;
import com.example.dnt.workshopdemo.data.FractionAdapter;
import com.example.dnt.workshopdemo.data.Superhero;
import com.example.dnt.workshopdemo.data.superheroAdapter;
import com.example.dnt.workshopdemo.presenters.FractionsListPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class FractionsFragment extends Fragment implements ViewContract.FractionList {

    @Inject
    FractionsListPresenter presenter;
    RecyclerView recyclerView;
    ArrayList<Fraction> list;
    FractionAdapter adapter;

    public FractionsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fractions, container, false);
        DaggerMainScreenComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        this.list = new ArrayList<>();
        this.presenter.loadFractions();
        recyclerView = (RecyclerView) view.findViewById(R.id.my_list);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        return view;
    }

    @Override
    public void showFractions(List<Fraction> fractions) {
        for (int i = 0; i < fractions.size(); i++) {
            this.list.add(fractions.get(i));
        }

        adapter = new FractionAdapter(getActivity(), this.list);
        recyclerView.setAdapter(adapter);
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
