package com.repository;

import com.exception.BeverageException;
import com.model.Coffee;
import com.model.Tea;
import com.util.EMUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BeverageDaoImpl implements BeverageDao{
    @Override
    public String addCoffee() throws BeverageException {
        Coffee coffee1 = new Coffee(1, 5.99, "Dark Roast", "Brazil", 4.5);
        Coffee coffee2 = new Coffee(2, 6.99, "Medium Roast", "Colombia", 3.2);
        Coffee coffee3 = new Coffee(3, 7.99, "Light Roast", "Ethiopia", 4.7);
        Coffee coffee4 = new Coffee(4, 8.99, "Espresso Blend", "Italy", 4.4);
        List<Coffee> coffees = Arrays.asList(coffee1 , coffee2 , coffee3 , coffee4) ;
        if(coffees.stream().anyMatch(Objects::isNull)) throw new BeverageException("null value passed") ;
        EntityManager entityManager = EMUtil.getConnection();
        entityManager.getTransaction().begin();
        coffees.forEach(entityManager::persist);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "coffees added successfully" ;
    }

    @Override
    public String addTea() throws BeverageException {
        List<Tea> teaList = new ArrayList<>();

        Tea tea1 = new Tea(1, 3.99, "Green Tea", "Jasmine", 4.5);
        Tea tea2 = new Tea(2, 4.99, "Black Tea", "Earl Grey", 4.2);
        Tea tea3 = new Tea(3, 5.99, "Oolong Tea", "Milk", 4.7);
        Tea tea4 = new Tea(4, 6.99, "Herbal Tea", "Peppermint", 4.4);

        teaList.add(tea1);
        teaList.add(tea2);
        teaList.add(tea3);
        teaList.add(tea4);

        if(teaList.stream().anyMatch(Objects::isNull)) throw new BeverageException("null value passed") ;
        EntityManager entityManager = EMUtil.getConnection();
        entityManager.getTransaction().begin();
        teaList.forEach(entityManager::persist);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "teas added successfully" ;


    }

    @Override
    public List<Coffee> getAllCoffee() throws BeverageException {

        EntityManager entityManager = EMUtil.getConnection();
        String jpql = "select c from Coffee c ORDER BY c.origin" ;
        Query query = entityManager.createQuery(jpql , Coffee.class) ;
        List<Coffee> coffeeList = query.getResultList() ;
        if(coffeeList.isEmpty()) throw new BeverageException("empty list")  ;
        return coffeeList;
    }

    @Override
    public List<Coffee> getCoffeeBasedOnId(int coffeeId) throws BeverageException {
        EntityManager entityManager = EMUtil.getConnection();
        Query query = entityManager.createNamedQuery("findByCoffeeId" , Coffee.class) ;
        query.setParameter(1,1) ;
        List<Coffee> coffeeList = query.getResultList() ;
        if(coffeeList.isEmpty()) throw new BeverageException("empty list")  ;
        return coffeeList;
    }
}
