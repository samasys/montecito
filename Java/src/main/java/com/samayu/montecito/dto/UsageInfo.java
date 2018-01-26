package com.samayu.montecito.dto;

public class UsageInfo implements Jsonable {

    private String _id;
    private String item;
    private String usage;

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

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String toJson(){
        return "{\"_id\":\""+_id+"\",\"item\":\""+item+"\",\"usage\":\""+usage+"\"}";
    }
}
