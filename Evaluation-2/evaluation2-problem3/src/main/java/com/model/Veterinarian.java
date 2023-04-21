package com.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int VeterinarianId;
    private String name;
    private String specialty;
    private String location;
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    @JoinTable(name = "Veterinarian_Pet" , joinColumns = @JoinColumn(name = "VeterinarianId") , inverseJoinColumns = @JoinColumn(name = "petId"))
    private List<Pet> petList = new ArrayList<>();

    @Override
    public String toString() {
        return "Veterinarian{" +
                "VeterinarianId=" + VeterinarianId +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", location='" + location + '\'' +
                ", petList=" + petList +
                '}';
    }

    public int getVeterinarianId() {
        return VeterinarianId;
    }

    public void setVeterinarianId(int veterinarianId) {
        VeterinarianId = veterinarianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public Veterinarian(String name, String specialty, String location) {
        this.name = name;
        this.specialty = specialty;
        this.location = location;
    }

    public Veterinarian() {
    }
}
