package com.repository;

import com.exception.PetException;
import com.exception.VeterinarianException;
import com.model.Pet;
import com.model.Veterinarian;
import com.util.EMUtil;
import jakarta.persistence.EntityManager;

public class VeterinarianDaoImpl implements VeterinarianDao{
    @Override
    public Veterinarian addVeterinarian(Veterinarian veterinarian) throws VeterinarianException{
        EntityManager entityManager = EMUtil.getEntityManager();
        if(veterinarian == null) throw new VeterinarianException("null value") ;
        entityManager.getTransaction().begin();
        entityManager.persist(veterinarian);
        entityManager.getTransaction().commit();
        entityManager.close();
        return veterinarian;

    }

    @Override
    public Veterinarian getVeterinarian(int vetId) throws VeterinarianException {
        EntityManager entityManager = EMUtil.getEntityManager();
        Veterinarian veterinarian = entityManager.find(Veterinarian.class , vetId) ;
        if (veterinarian == null) throw  new VeterinarianException("no vet found") ;
        return veterinarian;
    }

    @Override
    public Pet addPetWithVet(Pet pet, int vetId) throws VeterinarianException, PetException {
        if (pet == null) throw  new PetException("null value for pet");
        EntityManager entityManager = EMUtil.getEntityManager();
        Veterinarian veterinarian = entityManager.find(Veterinarian.class, vetId) ;
        if (veterinarian == null) throw new VeterinarianException("no vet found") ;
        entityManager.getTransaction().begin();
        pet.getVeterinarianList().add(veterinarian);
        veterinarian.getPetList().add(pet) ;
        entityManager.getTransaction().commit();
        entityManager.close();
        return pet;
    }

    @Override
    public Pet getPet(int petId) throws PetException {
        EntityManager entityManager = EMUtil.getEntityManager();
        Pet pet = entityManager.find(Pet.class , petId) ;
        if (pet == null) throw  new PetException("no pet found") ;
        return pet;
    }

    @Override
    public boolean addPetWithVet(int petId, int vetId) throws VeterinarianException, PetException {
        EntityManager entityManager = EMUtil.getEntityManager();
        Pet pet = entityManager.find(Pet.class , petId) ;
        if (pet == null) throw  new PetException("no pet found") ;
        Veterinarian veterinarian = entityManager.find(Veterinarian.class , vetId) ;
        if (veterinarian == null) throw  new VeterinarianException("no vet found") ;
        entityManager.getTransaction().begin();
        pet.getVeterinarianList().add(veterinarian);
        veterinarian.getPetList().add(pet) ;
        entityManager.getTransaction().commit();
        entityManager.close();
        return true ;

    }
}
