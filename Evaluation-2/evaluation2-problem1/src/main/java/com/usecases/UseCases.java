package com.usecases;

import com.model.Category;
import com.model.Product;
import com.model.Seller;
import com.repository.SellerDao;
import com.repository.SellerDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class UseCases {
    private SellerDao sellerDao;
    UseCases(){
        this.sellerDao = new SellerDaoImpl();
    }
    public static void main(String[] args) {

        UseCases useCases = new UseCases();
        System.out.println(useCases.addSeller());
        System.out.println(useCases.addProduct());
        System.out.println(useCases.getAllProduct());
        System.out.println(useCases.getProduct());
        System.out.println(useCases.addManyProduct());
    }

    public Seller addSeller(){
        Seller seller = new Seller("Zakir" ,"zakir@gmail.com" , "8928121676") ;
        return sellerDao.addSeller(seller) ;
    }

    public Seller addProduct(){
        Product product = new Product("Mobile" , 40000.0,12, Category.ELECTRONICS) ;
        return sellerDao.addProduct(product,1) ;
    }
    public List<Product> getAllProduct(){
        return sellerDao.getAllProduct(1) ;
    }

    public Product getProduct(){
        return sellerDao.getProduct(1);
    }
    public Seller addManyProduct(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("power bank" , 1000 , 25 , Category.ELECTRONICS));
        productList.add(new Product("cloths" , 5000 , 20 , Category.FASHION)) ;
        return sellerDao.addManyProduct(productList , 1) ;

    }



}
