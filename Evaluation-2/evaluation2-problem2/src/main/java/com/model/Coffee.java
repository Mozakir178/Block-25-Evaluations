package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findByCoffeeId" , query = "select c from Coffee c where c.coffeeId = ?1 and c.rating >=4")
public class Coffee extends Beverage{

    private int coffeeId;
    private double price;
    private String description;
    private String origin;

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeId=" + coffeeId +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    public Coffee() {
    }

    public Coffee(int coffeeId, double price, String description, String origin, double rating) {
        this.coffeeId = coffeeId;
        this.price = price;
        this.description = description;
        this.origin = origin;
        this.setRating(rating);
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
