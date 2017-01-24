package com.example.dnt.welcomescreenwithanimation.activities;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dnt.welcomescreenwithanimation.R;
import com.example.dnt.welcomescreenwithanimation.events.DrawerSectionItemClickedEvent;
import com.example.dnt.welcomescreenwithanimation.fragments.ExhibitsListFragment;
import com.example.dnt.welcomescreenwithanimation.fragments.GalleryFragment;
import com.example.dnt.welcomescreenwithanimation.fragments.ZooMapFragment;
import com.example.dnt.welcomescreenwithanimation.utilities.EventBus;
import com.squareup.otto.Subscribe;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private String mCurrentFragmentTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_opened,R.string.drawer_closed){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if(getSupportActionBar()!=null)
                    getSupportActionBar().setTitle(R.string.drawer_closed);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(getSupportActionBar()!=null)
                    getSupportActionBar().setTitle(R.string.drawer_opened);
            }
        };

        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        displayInitialFragment();

    }

    private void displayInitialFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, ExhibitsListFragment.getInstance()).commit();
        mCurrentFragmentTitle="Exhibits";
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder =  new AlertDialog.Builder(HomeActivity.this);

        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });



        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.GetInstance().register( this );
    }

    @Override
    protected void onStop() {
        EventBus.GetInstance().unregister( this );
        super.onStop();
    }

    @Subscribe
    public void onDrawerSectionItemClickEvent(DrawerSectionItemClickedEvent event){
        //Toast.makeText(this, "Section Clicked: "+ event.section,Toast.LENGTH_LONG).show();

        mDrawerLayout.closeDrawers();
        if(event==null || TextUtils.isEmpty(event.section) || event.section.equalsIgnoreCase(mCurrentFragmentTitle)){
            return;
        }

        Snackbar.make(findViewById(android.R.id.content), "HomeActivity: Section clicked "+event.section, Snackbar.LENGTH_LONG)
                .setAction("DISMISS", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                })
                .setActionTextColor(Color.RED)
                .show();

        if(event.section.equalsIgnoreCase("maps")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, ZooMapFragment.getIntace()).commit();
        }
        else if(event.section.equalsIgnoreCase("gallery")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, GalleryFragment.getInstance()).commit();
        }
        else if(event.section.equalsIgnoreCase("exhibits")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,ExhibitsListFragment.getInstance()).commit();
        }
        else{
            return;
        }
        mCurrentFragmentTitle=event.section;
    }
}
