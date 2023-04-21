package com.repository;

import com.exception.BeverageException;
import com.model.Coffee;
import com.model.Tea;

import java.util.List;

public interface BeverageDao {

    public String addCoffee() throws BeverageException ;
    public String addTea() throws BeverageException;
    public List<Tea> getAllTea() throws BeverageException;
    public List<Tea> getTeaById( int teaId) throws BeverageException;

    public List<Tea> getTeaLessThen100(String flavor) throws BeverageException;
}
