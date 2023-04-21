package com.repository;

import com.exception.ProductException;
import com.exception.SellerException;
import com.model.Product;
import com.model.Seller;

import java.util.List;

public interface SellerDao {

    Seller addSeller(Seller seller) throws SellerException ;
    Seller addProduct(Product product , int sellerId) throws ProductException , SellerException ;
    List<Product> getAllProduct(int sellerId) throws SellerException;
    Product getProduct(int productId) throws ProductException;
    Seller addManyProduct(List<Product> productList , int sellerId) throws SellerException;
}
