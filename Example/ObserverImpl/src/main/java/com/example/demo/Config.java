package com.example.demo;

import id.muhamadridwan.ClientConfig;
import id.muhamadridwan.Listener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by mridwan on 24/10/2017.
 */
@Configuration
public class Config extends ClientConfig {

    @Override
    public String getUsername() {
        return "username";
    }

    @Override
    public String getPassword() {
        return "123";
    }

    @Override
    public String getRangeIPWhiteList() {
        return null;
    }

    @Override
    public boolean isFilterIP() {
        return false;
    }

    @Override
    public Listener getListener() {
        return new ListenerImpl();
    }
}
