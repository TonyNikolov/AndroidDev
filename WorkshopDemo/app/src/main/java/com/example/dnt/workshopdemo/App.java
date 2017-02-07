package com.example.dnt.workshopdemo;

import android.app.Application;

import com.example.dnt.workshopdemo.data.AppModule;
import com.example.dnt.workshopdemo.data.DaggerNetComponent;
import com.example.dnt.workshopdemo.data.NetComponent;
import com.example.dnt.workshopdemo.data.NetModule;

/**
 * Created by dnt on 3.2.2017 г..
 */

public class App extends Application {
    NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://192.168.1.3:3000/"))
                .build();

    }

    public NetComponent getNetComponent(){
        return mNetComponent;
    }
}
