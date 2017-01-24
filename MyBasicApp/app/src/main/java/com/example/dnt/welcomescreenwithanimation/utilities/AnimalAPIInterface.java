package com.example.dnt.welcomescreenwithanimation.utilities;

import com.example.dnt.welcomescreenwithanimation.models.Animal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dnt on 24.1.2017 г..
 */

public interface AnimalAPIInterface {
    @GET("TonyNikolov/21c17a6627dece0c152b5c0f1188dfe5/raw/97684e4fcf452adff5e7bba072c992d5c34706c9/Exhibits.json")
    Call<List<Animal>> loadAnimals();
}
