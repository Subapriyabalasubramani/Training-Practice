package com.example.demo.service;


import com.example.demo.entity.Products;
import com.example.demo.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Products> getAllProducts(){
        return productRepo.findAll();
    }

    public Products getProductById(Integer id){
        return productRepo.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }

    public Products createProduct(Products p){
        return productRepo.save(p);
    }

    public Products updateProductById(Integer id, Products products){
        Products productsExists = getProductById(id);
        productsExists.setName(products.getName());
        productsExists.setPrice(products.getPrice());
        productsExists.setStock(products.getStock());

        return productRepo.save(productsExists);
    }

    public Products updateProductStocks(Integer id, int stock){
        Products productsExists = getProductById(id);
        productsExists.setStock(stock);

        return productRepo.save(productsExists);
    }

    public void deleteProductById(Integer id){
        productRepo.deleteById(id);
    }
}
