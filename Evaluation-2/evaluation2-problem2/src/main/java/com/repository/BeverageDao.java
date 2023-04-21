package com.repository;

import com.exception.BeverageException;
import com.model.Coffee;
import com.model.Tea;

import java.util.List;

public interface BeverageDao {

    public String addCoffee() throws BeverageException ;
    public String addTea() throws BeverageException;

    public List<Coffee> getAllCoffee() throws BeverageException;
    public List<Coffee> getCoffeeBasedOnId(int coffeeId) throws  BeverageException;
}
