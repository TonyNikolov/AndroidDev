package com.example.dnt.workshopdemo.main_screen;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dnt.workshopdemo.R;
import com.example.dnt.workshopdemo.data.SuperheroDetails;
import com.example.dnt.workshopdemo.superhero_details.SuperheroDetailsActivity;
import com.example.dnt.workshopdemo.superhero_details.SuperheroDetailsFragment;
import com.example.dnt.workshopdemo.utils.MyCommunicator;

public class MainActivity extends AppCompatActivity implements MyCommunicator {

    private TabsAdapter tabsAdapter;
    private ViewPager tabsContent;
    private Boolean isPhoneView = true;
    SuperheroDetailsFragment superheroDetailsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());

        tabsContent = (ViewPager) findViewById(R.id.container);
        tabsContent.setAdapter(tabsAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(tabsContent);

        FragmentManager fragmentManager = getSupportFragmentManager();

        superheroDetailsFragment = (SuperheroDetailsFragment) fragmentManager.findFragmentById(R.id.my_detail_fragment);
        View fragmentBView = findViewById(R.id.my_detail_fragment);
        isPhoneView = fragmentBView!=null && fragmentBView.getVisibility()== View.VISIBLE;

    }

    @Override
    public void displaySuperheroDetails(Integer superheroId) {
        if (!isPhoneView) {
            Intent intent = new Intent(this, SuperheroDetailsActivity.class);
            intent.putExtra(getString(R.string.GetSuperheroId), superheroId);
            startActivity(intent);
        } else {

            superheroDetailsFragment.setSuperheroById(superheroId);
        }
    }

    public class TabsAdapter extends FragmentStatePagerAdapter {

        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SuperheroesListFragment();
                case 1:
                    return new FractionsFragment();
                case 2:
                    return new SearchFragment();
                case 3:
                    return new AboutFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Heroes";
                case 1:
                    return "Factions";
                case 2:
                    return "Search";
                case 3:
                    return "About";
                default:
                    return "";
            }
        }
    }

}

