package id.muhamadridwan;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mridwan on 24/10/2017.
 */
public abstract class Observable {

    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void addObserver(List<Observer> os) {
        observers = os;
    }

    public void fireChanged() {
        observers.forEach(observer -> {

            String port = "8080";
            String fullURL = "";

            if (observer.getPort() != null || observer.getPort().equals("")) {
                port = observer.getPort();
            }

            if (observer.isHTTPS()) {
                fullURL = "https://" + observer.getIP() + ":" + port + "/on-update";
            } else {
                fullURL = "http://" + observer.getIP() + ":" + port + "/on-update";
            }

            HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
            hessianProxyFactory.setUser(observer.getUsername());
            hessianProxyFactory.setPassword(observer.getPassword());
            try {
                Listener listener = (Listener) hessianProxyFactory.create(Listener.class, fullURL);
                System.out.println(listener.toString());
                listener.onUpdate();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });

    }

}
