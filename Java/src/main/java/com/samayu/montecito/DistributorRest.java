package com.samayu.montecito;

import com.samayu.montecito.businessobjects.*;
import com.samayu.montecito.dto.ItemAvailabilityInfo;
import com.samayu.montecito.dto.UsageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Component
@Path("/api")
public class DistributorRest {

    @GET
    @Path("/itembins/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemBinDTO(){


        ItemBinDTO itemBinDTO = new ItemBinDTO();
        itemBinDTO.set_id(UUID.randomUUID().toString());
        itemBinDTO.setCapacity("17");
        itemBinDTO.setUom("weight");

        BinDTO binDTO = new BinDTO();
        binDTO.set_id(UUID.randomUUID().toString());
        binDTO.setBrand("Aristo");
        binDTO.setCapacity("17");
        binDTO.setName("FPO-35");

        itemBinDTO.setCrateBin( binDTO );

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.set_id(UUID.randomUUID().toString());
        itemDTO.setCategory(UUID.randomUUID().toString());
        itemDTO.setUom("GM");
        itemDTO.setMaterial("ms");

        itemBinDTO.setItem( itemDTO );

        DeviceDTO device = new DeviceDTO();
        device.set_id(UUID.randomUUID().toString());
        device.setLocation("BLR-ELCITA-BLKA-FLR3-RM10-RK3-SF1");
        device.setName("cBin-SA-1");
        device.setSlno("SA20W0000001");

        itemBinDTO.setCurrDevice(device);

        ThresholdDTO thresholdDTO = new ThresholdDTO();
        thresholdDTO.setMax("10");
        thresholdDTO.setMin("2");
        thresholdDTO.setNormal("6");
        itemBinDTO.setThreshold( thresholdDTO );

        ReadingDTO readingDTO = new ReadingDTO();
        readingDTO.set_id(UUID.randomUUID().toString());

        itemBinDTO.setLastReading( readingDTO );

        ReadingValueDTO readingValueDTO = new ReadingValueDTO();
        readingValueDTO.setWeight("3.5");
        readingDTO.setReading(readingValueDTO);

        List<ItemBinDTO> list = new LinkedList<ItemBinDTO>();
        list.add(itemBinDTO);
        return Response.ok().entity(list).build();
    }

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

        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Screw Driver - SCA 147");
        info.setUsage("57");
        list.add ( info );

        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Screw Driver - SGA 163");
        info.setUsage("92");
        list.add ( info );

        return Response.ok().entity(list).build();
    }


}
