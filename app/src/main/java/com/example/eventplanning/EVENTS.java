package com.example.eventplanning;

public class EVENTS {

    private String type;
    private String ven;

    private int EVENT_ID;
    private String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVen() {
        return ven;
    }

    public void setVen(String ven) {
        this.ven = ven;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EVENTS(String type, String ven, String date, int EVENT_ID) {
        this.type = type;
        this.ven = ven;
        this.date = date;
        this.EVENT_ID = EVENT_ID;
    }

    @Override
    public String toString() {
        return "EVENTS{" +
                "type='" + type + '\'' +
                ", ven='" + ven + '\'' +
                ", EVENT_ID=" + EVENT_ID +
                ", date='" + date + '\'' +
                '}';
    }
}
