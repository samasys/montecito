package com.samayu.montecito;

import com.samayu.montecito.dto.ItemAvailabilityInfo;
import com.samayu.montecito.dto.Jsonable;
import com.samayu.montecito.dto.MontecitoMessage;
import com.samayu.montecito.dto.UsageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Configuration
@EnableScheduling

public class Scheduler {

    @Autowired
    private EventSocketMediator mediator;

    @Scheduled(fixedRate = 10000 )
    public void publishConsumptionInfo(){

        int base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;



        System.out.println("Time Event "+System.currentTimeMillis());
        List<Jsonable> list = new ArrayList<Jsonable>();
        UsageInfo info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Slotted Head Machine Screws - DIN 84A");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;
        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Self Clinching Nuts - DXA 234");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;
        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Self Clinching Nuts - DBA 945");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;
        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Self Clinching Nuts - SCA 567");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;
        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Screwdriver - SCA 517");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;
        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Screws 5 inch - SCA 367");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;
        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Nuts 1.4 inch - SCA 674");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;
        info = new UsageInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setItem("Nuts 1.8 inch - SCA 654");
        info.setUsage(String.valueOf(base));
        list.add ( info );

        MontecitoMessage message = new MontecitoMessage();
        message.setType("consumption");
        message.setPayload( list );
        mediator.publish(message);
    }

    @Scheduled(fixedRate = 12000 )
    public void publishAvailablityInfo(){

        int base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;



        System.out.println("Time Event "+System.currentTimeMillis());
        List<Jsonable> list = new ArrayList<Jsonable>();

        ItemAvailabilityInfo info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable(base+"%");
        info.setStatus(getCriticality(base));
        info.setLocation("BLR");
        info.setItem("Slotted Head Machine Screws - DIN 84A");
        list.add( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;


        info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable(base+"%");
        info.setStatus(getCriticality(base));
        info.setLocation("BLR");
        info.setItem("Self Clinching Nuts - DXA 234");
        list.add( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;


        info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable(base+"%");
        info.setStatus(getCriticality(base));
        info.setLocation("BLR");
        info.setItem("Self Clinching Nuts - DBA 945");
        list.add( info );

        base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;


        info = new ItemAvailabilityInfo();
        info.set_id(UUID.randomUUID().toString());
        info.setAvailable(base+"%");
        info.setStatus(getCriticality(base));
        info.setLocation("BLR");
        info.setItem("Self Clinching Nuts - SCA 567");
        list.add( info );


        MontecitoMessage message = new MontecitoMessage();
        message.setType("availability");
        message.setPayload( list );
        mediator.publish(message);

    }

    public String getCriticality(int number){
        if( number <=20 ) return "critical";
        else if( number >20 && number <40 ) return "low";
        else return "med";
    }

}
