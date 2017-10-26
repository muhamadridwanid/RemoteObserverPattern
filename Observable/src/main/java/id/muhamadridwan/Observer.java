package id.muhamadridwan;

/**
 * Created by mridwan on 24/10/2017.
 */
public interface Observer {
    String getUsername();

    String getPassword();

    String getIP();

    String getPort();

    boolean isHTTPS();

}
