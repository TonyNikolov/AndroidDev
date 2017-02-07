package com.example.dnt.workshopdemo.superhero_details;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dnt.workshopdemo.R;

import static com.example.dnt.workshopdemo.utils.ActivityUtils.addFragmentToActivity;

/**
 * Created by dnt on 7.2.2017 г..
 */

public class SuperheroDetailsActivity  extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero_details);

        Integer postId = getIntent().getIntExtra(getString(R.string.GetSuperheroId),0);
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.GetSuperheroId),postId);
        SuperheroDetailsFragment detailScreenFragment =  new SuperheroDetailsFragment();
        detailScreenFragment.setArguments(bundle);


        addFragmentToActivity(getSupportFragmentManager(),detailScreenFragment, R.id.my_detail_fragment);

    }
}
