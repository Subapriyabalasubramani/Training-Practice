package com.example.demo.mapper;

import com.example.demo.dto.ProductRequestDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDto dto){
        Product p = new Product();
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());

        return p;
    }

    public static void updateEntity(ProductRequestDto dto, Product entity){
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
    }

    public static ProductResponseDto toResponse(Product entity){
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setName(entity.getName());
        responseDto.setPrice(entity.getPrice());
        responseDto.setStock(entity.getStock());

        return responseDto;
    }
}
