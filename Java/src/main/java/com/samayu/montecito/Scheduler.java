package com.samayu.montecito;

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
    public void publishUpdates(){

        int base = new Random().nextInt()%100;
        if( base <0 ) base = base*-1;



        System.out.println("Time Event "+System.currentTimeMillis());
        List<UsageInfo> list = new ArrayList<UsageInfo>();
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

        mediator.publish(list);
    }

}
