package com.samayu.montecito;

import com.samayu.montecito.dto.UserLogin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/auth")
public class AuthenticationRest {

    public AuthenticationRest(){
    }

    @GET
    @Path("/ping")
    public String ping(){
        return "HelloWorld";
    }

    @POST
    @Path("/local")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@FormParam("userId") String userId , @FormParam("password") String password ){

        String token = "35";

        String encoded = new BASE64Encoder().encode(token.getBytes());

        UserLogin login = new UserLogin();
        login.setToken(encoded );
        login.setFirstName("TestFirst");
        login.setLastName("TestLast");

        if( userId.equalsIgnoreCase("wrong")){
            return Response.status(403).build();
        }

        return Response.ok().entity(login).build();
    }

}
