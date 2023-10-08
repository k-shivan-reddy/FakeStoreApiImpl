package dev.shivan.fakestoreimpl.service;

import java.util.List;

import dev.shivan.fakestoreimpl.dto.ProductDto;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto createProduct(ProductDto genericProductDTO);
}
