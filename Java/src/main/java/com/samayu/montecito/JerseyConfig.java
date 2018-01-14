package com.samayu.montecito;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(AuthenticationRest.class);
        register(DistributorRest.class );
    }
}
