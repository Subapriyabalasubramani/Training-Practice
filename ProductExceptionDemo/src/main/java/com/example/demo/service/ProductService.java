package com.example.demo.service;

import com.example.demo.dto.ProductRequestDto;
import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(Integer id){
        return productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found with id: "+id));
    }

    public Product createProduct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(Integer id, ProductRequestDto productDTO){
        Product productExists = getProductById(id);
        ProductMapper.updateEntity(productDTO, productExists);
        return productRepo.save(productExists);
    }

    public Product updateStock(Integer id, int stock){
        if(stock < 0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        Product productExists = getProductById(id);
        productExists.setStock(stock);
        return productRepo.save(productExists);
    }

    public void deleteProduct(Integer id){
        Product productExists = getProductById(id);
        productRepo.delete(productExists);
    }
}
