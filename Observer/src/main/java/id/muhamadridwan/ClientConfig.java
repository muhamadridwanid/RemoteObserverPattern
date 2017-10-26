package id.muhamadridwan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import java.io.IOException;

/**
 * Created by mridwan on 24/10/2017.
 */
public abstract class ClientConfig extends WebSecurityConfigurerAdapter {

    public abstract String getUsername();

    public abstract String getPassword();

    public abstract String getRangeIPWhiteList();

    public abstract boolean isFilterIP();

    public abstract Listener getListener();

    @Bean(name = "/on-update")
    RemoteExporter accountService() throws IOException {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(getListener());
        exporter.setServiceInterface(Listener.class);
        return exporter;
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(getUsername())
                .password(getPassword())
                .roles("TRUSTED");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .httpBasic().and()
                .headers().cacheControl();

        if (isFilterIP()) {
            http
                    .authorizeRequests()
                    .antMatchers("/on-update")
                    .access("hasRole('TRUSTED') and hasIpAddress('" + getRangeIPWhiteList() + "')")
                    .anyRequest().denyAll();
        } else {
            http
                    .authorizeRequests()
                    .antMatchers("/on-update")
                    .access("hasRole('TRUSTED')")
                    .anyRequest().denyAll();
        }
    }
}
