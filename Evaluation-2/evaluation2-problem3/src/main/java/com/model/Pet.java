package com.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petId;
    private String petName;
    @ManyToMany(fetch = FetchType.EAGER , mappedBy = "petList" , cascade = CascadeType.PERSIST)
    private List<Veterinarian> veterinarianList = new ArrayList<>();

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                '}';
    }

    public Pet() {
    }

    public Pet(String petName) {
        this.petName = petName;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public List<Veterinarian> getVeterinarianList() {
        return veterinarianList;
    }

    public void setVeterinarianList(List<Veterinarian> veterinarianList) {
        this.veterinarianList = veterinarianList;
    }
}
