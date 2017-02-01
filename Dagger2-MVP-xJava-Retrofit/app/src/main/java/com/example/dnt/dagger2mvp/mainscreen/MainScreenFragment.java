package com.example.dnt.dagger2mvp.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class MainScreenFragment extends Fragment implements MainScreenContract.View  {
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Inject
    MainScreenPresenter mainScreenPresenter;

    public MainScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_screen,container,false);
        DaggerMainScreenComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);
        list = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.my_list);


        mainScreenPresenter.loadPost();
        return view;
    }

    @Override
    public void showPosts(List<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            list.add(posts.get(i).getTitle());
        }

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
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
