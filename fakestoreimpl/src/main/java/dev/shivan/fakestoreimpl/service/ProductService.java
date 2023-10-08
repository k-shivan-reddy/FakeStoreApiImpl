package dev.shivan.fakestoreimpl.service;

import java.util.List;

import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.exceptions.NotFoundException;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto createProduct(ProductDto genericProductDTO);
    ProductDto getProductbyId(int id) throws NotFoundException;
    ProductDto deleteProductById(int id) throws NotFoundException;
    ProductDto updateProductById(int id,ProductDto productDto) throws NotFoundException;
}
