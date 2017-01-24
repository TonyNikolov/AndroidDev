package com.example.dnt.welcomescreenwithanimation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;

import com.example.dnt.welcomescreenwithanimation.R;
import com.example.dnt.welcomescreenwithanimation.adapters.ExhibitsAdapter;
import com.example.dnt.welcomescreenwithanimation.models.Animal;
import com.example.dnt.welcomescreenwithanimation.utilities.AnimalAPIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.google.android.gms.analytics.internal.zzy.r;

/**
 * Created by dnt on 24.1.2017 г..
 */

public class ExhibitsListFragment extends ListFragment{

    private final String base_url = "https://gist.githubusercontent.com/";
    private ExhibitsAdapter mAdapter;

    public static ExhibitsListFragment getInstance(){
        ExhibitsListFragment fragment = new ExhibitsListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListShown(false);
        mAdapter=new ExhibitsAdapter(getActivity(),0);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        AnimalAPIInterface animalAPI = retrofit.create(AnimalAPIInterface.class);
        Call<List<Animal>> call = animalAPI.loadAnimals();
        call.enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                if(response.body()==null || response.body().isEmpty())
                    return;

                for(Animal animal: response.body()){
                    mAdapter.add(animal);
                }

                mAdapter.notifyDataSetChanged();
                setListAdapter(mAdapter);
                setListShown(true);
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {
                Log.v("Zoo", "Retrofit error "+  t.getMessage());
            }
        });
    }

}
