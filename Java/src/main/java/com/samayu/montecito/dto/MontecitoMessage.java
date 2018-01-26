package com.samayu.montecito.dto;

import java.util.List;

public class MontecitoMessage {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Jsonable> getPayload() {
        return payload;
    }

    public void setPayload(List<Jsonable> payload) {
        this.payload = payload;
    }

    public String type;
    public List<Jsonable> payload;

    public String toJson(){
        StringBuilder builder = new StringBuilder("{");
        builder.append("\"type\"");
        builder.append(":");
        builder.append("\"");
        builder.append(type);
        builder.append("\",\"payload\":");

        builder.append("[");

        for(Jsonable entry:payload){
            builder.append( entry.toJson() );
            builder.append( "," );
        }

        builder.deleteCharAt(builder.length()-1);
        builder.append("]}");

        return builder.toString();

    }
}
