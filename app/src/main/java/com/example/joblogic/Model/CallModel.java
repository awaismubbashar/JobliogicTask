package com.example.joblogic.Model;

public class CallModel {

    private String id;
    private String name;
    private String number;

    public CallModel(String id, String title, String desc) {
        this.name = title;
        this.number = desc;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getDesc() {
        return number;
    }

    public void setDesc(String desc) {
        this.number = desc;
    }
}
