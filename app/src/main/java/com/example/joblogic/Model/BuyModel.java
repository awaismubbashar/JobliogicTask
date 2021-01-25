package com.example.joblogic.Model;

public class BuyModel {

    private String id;
    private String name;
    private String price;
    private String quantity;
    private String type;

    public BuyModel(String id, String name, String price, String quantity, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public BuyModel() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
