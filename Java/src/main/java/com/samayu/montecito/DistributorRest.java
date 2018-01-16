package com.samayu.montecito;

import com.samayu.montecito.dto.ItemAvailabilityInfo;
import com.samayu.montecito.dto.UsageInfo;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Path("/api")
public class DistributorRest {

    @GET
    @Path("/tasks/user/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dashboard(@HeaderParam("Authorization") String auth){

        if( auth == null || auth.trim().length() == 0 ) {
            return Response.status(403).build();
        }

        List<ItemAvailabilityInfo> list = new ArrayList<ItemAvailabilityInfo>();

        ItemAvailabilityInfo info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable("20%");
        info.setStatus("critical");
        info.setLocation("BLR");
        info.setItem("Slotted Head Machine Screws - DIN 84A");
        list.add( info );

        info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable("32%");
        info.setStatus("low");
        info.setLocation("BLR");
        info.setItem("Self Clinching Nuts - DXA 234");
        list.add( info );

        info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable("62%");
        info.setStatus("med");
        info.setLocation("BLR");
        info.setItem("Self Clinching Nuts - DBA 945");
        list.add( info );

        info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable("45%");
        info.setStatus("med");
        info.setLocation("BLR");
        info.setItem("Self Clinching Nuts - SCA 567");
        list.add( info );

        return Response.ok().entity( list ).build();
    }

    @GET
    @Path("/items/consumption/today/{type}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response itemsConsumed(@HeaderParam("Authorization") String auth, @PathParam("type") String type){

        if( auth == null || auth.trim().length() == 0 ) {
            return Response.status(403).build();
        }

        List<UsageInfo> list = new ArrayList<UsageInfo>();
        UsageInfo info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Slotted Head Machine Screws - DIN 84A");
        info.setUsage("50");
        list.add ( info );

        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Self Clinching Nuts - DXA 234");
        info.setUsage("75");
        list.add ( info );

        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Self Clinching Nuts - DBA 945");
        info.setUsage("65");
        list.add ( info );

        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Self Clinching Nuts - SCA 567");
        info.setUsage("95");
        list.add ( info );

        return Response.ok().entity(list).build();
    }


}
