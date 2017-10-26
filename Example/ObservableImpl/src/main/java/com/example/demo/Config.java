package com.example.demo;

import id.muhamadridwan.Observable;
import id.muhamadridwan.Observer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by mridwan on 24/10/2017.
 */
@Component
public class Config extends Observable {

    public void init() {

        Observer observer1 = new Observer() {
            public String getUsername() {
                return "username";
            }

            public String getPassword() {
                return "123";
            }

            public String getIP() {
                return "127.0.0.1";
            }

            public String getPort() {
                return "8080";
            }

            public boolean isHTTPS() {
                return false;
            }
        };


        Observer observer2 = new Observer() {
            public String getUsername() {
                return "username";
            }

            public String getPassword() {
                return "123";
            }

            public String getIP() {
                return "172.18.2.13";
            }

            public String getPort() {
                return "8080";
            }

            public boolean isHTTPS() {
                return false;
            }
        };

        addObserver(observer1);
        addObserver(observer2);

        fireChanged();
    }
}
