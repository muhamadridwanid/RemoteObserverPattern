import id.muhamadridwan.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mridwan on 25/10/2017.
 */
public class ObserverService {
    List<Observer> getObserverAll() {
        List<Observer> observers = new ArrayList<Observer>();
        Observer o = new Observer() {
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

        observers.add(o);
        return observers;
    }

}
