package com.example.dnt.welcomescreenwithanimation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dnt.welcomescreenwithanimation.R;
import com.example.dnt.welcomescreenwithanimation.models.Animal;
import com.google.android.gms.vision.text.Text;
import com.squareup.picasso.Picasso;

public class ExhibitsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibits_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Animal animal = getIntent().getExtras().getParcelable(getString(R.string.animal_key));

        TextView species = (TextView) findViewById(R.id.exhibit_detail_species);
        TextView description = (TextView) findViewById(R.id.exhibit_detail_description);
        ImageView image = (ImageView) findViewById(R.id.exhibit_detail_image);
        species.setText(animal.getSpecies());
        description.setText(animal.getDescription());
        Picasso.with(this).load(animal.getImage()).into(image);
    }
}
