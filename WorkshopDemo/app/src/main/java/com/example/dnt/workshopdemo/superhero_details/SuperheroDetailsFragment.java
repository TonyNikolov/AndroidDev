package com.example.dnt.workshopdemo.superhero_details;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dnt.workshopdemo.App;
import com.example.dnt.workshopdemo.R;
import com.example.dnt.workshopdemo.ViewContract;
import com.example.dnt.workshopdemo.data.Superhero;
import com.example.dnt.workshopdemo.data.SuperheroDetails;
import com.example.dnt.workshopdemo.main_screen.DaggerMainScreenComponent;
import com.example.dnt.workshopdemo.main_screen.MainScreenModule;
import com.example.dnt.workshopdemo.presenters.SuperheroDetailsPresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class SuperheroDetailsFragment extends Fragment implements ViewContract.SuperheroDetailsContract{

    SuperheroDetails superheroDetails;
    Integer superheroId;
    @Inject
    SuperheroDetailsPresenter presenter;

    public SuperheroDetailsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_superhero_details, container, false);

        DaggerSuperheroDetailsComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .superheroDetailsModule(new SuperheroDetailsModule(this))
                .build().inject(this);

        Bundle arguments = this.getArguments();
        if(arguments!=null) {
            superheroId = getArguments().getInt(getString(R.string.GetSuperheroId));
        }
        else{
            superheroId=11;
        }
        presenter.loadSuperheroeDetailsById(superheroId);

        return view;
    }



    @Override
    public void showSuperheroe(SuperheroDetails superhero) {
        this.superheroDetails = superhero;

        View view = this.getView();
        ImageView imageView = (ImageView)view.findViewById(R.id.ivImage);
        Picasso.with(getActivity()).load(superhero.getImageUrl()).into(imageView);
        ((TextView)view.findViewById(R.id.tvSuperheroSecretIdentity)).setText("Secret Identity: " + superheroDetails.getSecretIdentity());
        ((TextView) view.findViewById(R.id.tvSuperheroName)).setText("Name: " + superheroDetails.getName());
    }

    public void setSuperheroById(Integer id) {

        presenter.loadSuperheroeDetailsById(id);
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
