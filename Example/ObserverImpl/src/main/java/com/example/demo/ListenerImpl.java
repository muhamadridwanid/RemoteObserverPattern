package com.example.demo;

import id.muhamadridwan.Listener;

import java.io.Serializable;

/**
 * Created by mridwan on 24/10/2017.
 */
public class ListenerImpl implements Listener {
    @Override
    public void onUpdate(Serializable... serializables) {
        System.out.println("Ini Dieksekusi");
    }
}
