package com.example.demo.controller;

import com.example.demo.dto.ProductRequestDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        List<ProductResponseDto> list = productService.getAllProducts().stream().map(ProductMapper::toResponse).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Integer id){
        ProductResponseDto response = ProductMapper.toResponse(productService.getProductById(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@Valid @RequestBody ProductRequestDto request){
        Product newProduct = productService.createProduct(ProductMapper.toEntity(request));
        URI location = URI.create("/api/product/"+newProduct.getId());
        return ResponseEntity.created(location).body(ProductMapper.toResponse(newProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateById(@Valid @PathVariable Integer id, @RequestBody ProductRequestDto request){
        ProductResponseDto response = ProductMapper.toResponse(productService.updateProduct(id, request));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProductStock(@Valid @PathVariable Integer id, @RequestBody Map<String, Object> body){
        int stock = (int)body.getOrDefault("stock", 0);
        ProductResponseDto response = ProductMapper.toResponse(productService.updateStock(id, stock));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
