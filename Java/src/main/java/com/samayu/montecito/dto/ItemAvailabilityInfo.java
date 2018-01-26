package com.samayu.montecito.dto;

public class ItemAvailabilityInfo implements Jsonable{
    private String _id;
    private String item;
    private String location;
    private String status;
    private String available;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String toJson(){
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        builder.append("\"_id\":");
        builder.append("\"");
        builder.append(_id);
        builder.append("\",");

        builder.append("\"item\":");
        builder.append("\"");
        builder.append(item);
        builder.append("\",");

        builder.append("\"location\":");
        builder.append("\"");
        builder.append(location);
        builder.append("\",");

        builder.append("\"status\":");
        builder.append("\"");
        builder.append(status);
        builder.append("\",");


        builder.append("\"available\":");
        builder.append("\"");
        builder.append(available);
        builder.append("\"}");


        return builder.toString();
    }
}
