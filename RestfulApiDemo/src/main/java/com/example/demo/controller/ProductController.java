package com.example.demo.controller;

import com.example.demo.entity.Products;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAll(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Products> create(@RequestBody Products p){
        Products product = productService.createProduct(p);

        URI location = URI.create("/api/products/" + product.getId());
        return ResponseEntity.created(location).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateAll(@PathVariable Integer id, @RequestBody Products p){
        return ResponseEntity.ok(productService.updateProductById(id, p));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Products> updateStock(@PathVariable Integer id, @RequestBody Map<String, Object> body){
        int stock = (int) body.getOrDefault("stock", 0);
        return ResponseEntity.ok(productService.updateProductStocks(id, stock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
