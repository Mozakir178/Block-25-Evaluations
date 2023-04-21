package com.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;
    private String name;
    private String email;
    private String mobile;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL ,mappedBy = "seller")
    List<Product> productList = new ArrayList<>();

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId=" + sellerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Seller() {
    }

    public Seller(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}
