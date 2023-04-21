package com.repository;

import com.exception.ProductException;
import com.exception.SellerException;
import com.model.Product;
import com.model.Seller;
import com.util.EMUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SellerDaoImpl  implements  SellerDao{
    @Override
    public Seller addSeller(Seller seller) throws SellerException {
        EntityManager entityManager = EMUtil.getConnection();
        if (seller == null) throw new SellerException("seller is null") ;
        Seller seller1 = entityManager.find(Seller.class , seller.getSellerId()) ;
        if(seller1 != null) throw new SellerException("seller already exist") ;
        entityManager.getTransaction().begin();
        entityManager.persist(seller);
        entityManager.getTransaction().commit();
        entityManager.close();
        return seller;

    }

    @Override
    public Seller addProduct(Product product, int sellerId) throws ProductException, SellerException {
        EntityManager entityManager = EMUtil.getConnection();
        if (product == null) throw new ProductException("product is null") ;
        Seller seller = entityManager.find(Seller.class , sellerId) ;
        if(seller == null) throw new SellerException("seller does not exist") ;
        entityManager.getTransaction().begin();
        seller.getProductList().add(product) ;
        product.setSeller(seller);
        entityManager.getTransaction().commit();
        entityManager.close();
        return seller;
    }

    @Override
    public List<Product> getAllProduct(int sellerId) throws SellerException {
        EntityManager entityManager = EMUtil.getConnection();
        Seller seller = entityManager.find(Seller.class , sellerId) ;
        if(seller == null) throw new SellerException("No seller found") ;
        return seller.getProductList();
    }

    @Override
    public Product getProduct(int productId) throws ProductException {
        EntityManager entityManager = EMUtil.getConnection();
        Product product = entityManager.find(Product.class , productId) ;
        if(product == null) throw new ProductException("No product found") ;
        return product;
    }

    @Override
    public Seller addManyProduct(List<Product> productList, int sellerId) throws SellerException {
        EntityManager entityManager = EMUtil.getConnection();
        if(productList.isEmpty()) throw new ProductException("Product list is empty");
        Seller seller = entityManager.find(Seller.class , sellerId) ;
        if (seller == null) throw new SellerException("No seller found") ;
        entityManager.getTransaction().begin();
        seller.getProductList().addAll(productList);
        productList.forEach(product -> product.setSeller(seller));
        entityManager.getTransaction().commit();
        entityManager.close();
        return seller;
    }
}
