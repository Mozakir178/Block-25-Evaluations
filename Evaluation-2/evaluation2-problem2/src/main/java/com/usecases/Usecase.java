package com.usecases;

import com.repository.BeverageDao;
import com.repository.BeverageDaoImpl;

public class Usecase {

    private BeverageDao beverageDao;
    public Usecase(){
        this.beverageDao = new BeverageDaoImpl();
    }

    public static void main(String[] args) {
        Usecase usecase = new Usecase();
        System.out.println(usecase.beverageDao.addCoffee());
        System.out.println(usecase.beverageDao.addTea());
        System.out.println(usecase.beverageDao.getAllCoffee());
        System.out.println(usecase.beverageDao.getCoffeeBasedOnId(1));
    }


}
