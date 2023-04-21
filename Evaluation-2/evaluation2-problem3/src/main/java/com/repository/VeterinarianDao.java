package com.repository;

import com.exception.PetException;
import com.exception.VeterinarianException;
import com.model.Pet;
import com.model.Veterinarian;

public interface VeterinarianDao {

    public Veterinarian addVeterinarian(Veterinarian veterinarian) throws VeterinarianException ;
    public Veterinarian getVeterinarian(int vetId) throws VeterinarianException;
    public Pet addPetWithVet(Pet pet , int vetId) throws VeterinarianException , PetException;
    public Pet getPet(int petId) throws PetException;
    public boolean addPetWithVet(int petId, int vetId) throws VeterinarianException, PetException;
}
