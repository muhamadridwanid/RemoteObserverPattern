import id.muhamadridwan.Observable;
import id.muhamadridwan.Observer;

import java.util.List;

/**
 * Created by mridwan on 25/10/2017.
 */
public class NotificationService extends Observable {

    public NotificationService() {
        ObserverService observerService = new ObserverService();
        List<Observer> os = observerService.getObserverAll();
        addObserver(os);
    }

}
