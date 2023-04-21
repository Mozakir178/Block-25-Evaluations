package com.model;

import jakarta.persistence.Entity;

@Entity
public class Tea extends Beverage{

    private int teaId;
    private double price;
    private String description;
    private String flavor;

    @Override
    public String toString() {
        return "Tea{" +
                "teaId=" + teaId +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", flavor='" + flavor + '\'' +
                '}';
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Tea() {
    }

    public Tea(int teaId, double price, String description, String flavor , double rating) {
        this.teaId = teaId;
        this.price = price;
        this.description = description;
        this.flavor = flavor;
        this.setRating(rating);
    }
}
