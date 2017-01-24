package com.example.dnt.welcomescreenwithanimation.fragments;

import android.app.Fragment;
import android.widget.ZoomButton;

import com.google.android.gms.maps.SupportMapFragment;

import static android.R.attr.fragment;

/**
 * Created by dnt on 24.1.2017 г..
 */

public class ZooMapFragment extends SupportMapFragment{
    public static ZooMapFragment getIntace(){
        ZooMapFragment fragment = new ZooMapFragment();

        return fragment;
    }
}
