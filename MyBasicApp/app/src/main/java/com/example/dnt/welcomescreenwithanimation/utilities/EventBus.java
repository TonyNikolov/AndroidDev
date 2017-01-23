package com.example.dnt.welcomescreenwithanimation.utilities;

import com.squareup.otto.Bus;

/**
 * Created by dnt on 23.1.2017 г..
 */

public class EventBus extends Bus {
    private static final EventBus bus = new EventBus();

    public static Bus GetInstance(){
        return bus;
    }

    private EventBus(){};
}
