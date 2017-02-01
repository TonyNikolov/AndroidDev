package com.example.dnt.dagger2mvp.mainscreen;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dnt.dagger2mvp.App;
import com.example.dnt.dagger2mvp.R;
import com.example.dnt.dagger2mvp.data.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragmentToActivity(getSupportFragmentManager(), new MainScreenFragment(), R.id.my_list_fragment);
    }

    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
