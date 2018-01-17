package com.samayu.montecito;

import com.samayu.montecito.dto.UsageInfo;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ServerEndpoint("/event")
@Component

public class EventSocketMediator {
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("mediator: open websocket channel for client " );
        peers.add(session);

        try {
            session.getBasicRemote().sendText("good to be in touch");
        } catch (IOException e) {
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("mediator: closed websocket channel for client " );
        peers.remove(session);
    }


    public void publish(List<UsageInfo> message) {

            System.out.println("Total Clients "+peers.size());
            StringBuilder jsonString = new StringBuilder( "[");
            for(UsageInfo u : message ){
                jsonString.append(u.toJson()).append(",");
            }

            jsonString.deleteCharAt(jsonString.length()-1);
            jsonString.append("]");
            for (Session s : peers) {
                try {



                    System.out.println( "Session open = "+s.isOpen());
                    System.out.println("Sending to "+s);
                    s.getBasicRemote().sendText(jsonString.toString());
                    System.out.println("send message to peer ");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
    }

}
