package com.example.dnt.workshopdemo.main_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dnt.workshopdemo.R;
import com.example.dnt.workshopdemo.ViewContract;

/**
 * Created by dnt on 3.2.2017 г..
 */

public class AboutFragment extends Fragment implements ViewContract.About{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_fragment, container, false);
        ((TextView)view.findViewById(R.id.about_fragment)).setText("vliza about");
        return view;
    }

    @Override
    public void showAbout() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }
}
