package com.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type" , discriminatorType = DiscriminatorType.STRING)
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beverageId;
    private double rating;

    @Override
    public String toString() {
        return "Beverage{" +
                "beverageId=" + beverageId +
                ", rating=" + rating +
                '}';
    }

    public int getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(int beverageId) {
        this.beverageId = beverageId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
