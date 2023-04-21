package com.usecases;

import com.exception.PetException;
import com.exception.VeterinarianException;
import com.model.Pet;
import com.model.Veterinarian;
import com.repository.VeterinarianDao;
import com.repository.VeterinarianDaoImpl;

public class Usecases {

    private final VeterinarianDao veterinarianDao;
    public Usecases(){
        this.veterinarianDao = new VeterinarianDaoImpl() ;
    }

    public static void main(String[] args) throws VeterinarianException, PetException {
        Usecases usecases = new Usecases();
        System.out.println(usecases.addVet() );
        System.out.println(usecases.singleVet());
        System.out.println(usecases.getVet());
        System.out.println(usecases.addPet());
        System.out.println(usecases.getPet());
        System.out.println(usecases.addPetAndVet()) ;
    }
    public Veterinarian addVet() throws VeterinarianException {
        Veterinarian veterinarian = new Veterinarian("Zakir" , "operations" , "Amravati") ;
        Pet pet  = new Pet("tommy") ;
        pet.getVeterinarianList().add(veterinarian) ;
        veterinarian.getPetList().add(pet) ;
        return veterinarianDao.addVeterinarian(veterinarian ) ;
    }
    public Veterinarian singleVet() throws VeterinarianException {
        Veterinarian veterinarian = new Veterinarian("shakir" , "OBD" , "Nagpur") ;
        return veterinarianDao.addVeterinarian(veterinarian) ;
    }

    public Veterinarian getVet() throws VeterinarianException {
        return veterinarianDao.getVeterinarian(1) ;
    }

    public Pet addPet() throws VeterinarianException, PetException {
        Pet pet = new Pet("lucky") ;
        return veterinarianDao.addPetWithVet(pet , 1) ;
    }

    public Pet getPet() throws PetException {
        return veterinarianDao.getPet(1) ;
    }

    public boolean addPetAndVet() throws VeterinarianException, PetException {
        return veterinarianDao.addPetWithVet(1 , 2) ;
    }

}
