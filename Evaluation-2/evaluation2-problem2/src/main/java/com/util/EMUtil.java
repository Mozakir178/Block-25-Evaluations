package com.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtil {

    private static final EntityManagerFactory emf ;
    static {
        emf = Persistence.createEntityManagerFactory("persistence-Unit") ;
    }
    public static EntityManager getConnection(){
        return emf.createEntityManager();
    }
}
