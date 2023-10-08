package dev.shivan.fakestoreimpl.service;

import java.util.List;

import dev.shivan.fakestoreimpl.dto.CategoryDto;
import dev.shivan.fakestoreimpl.dto.ProductDto;

public interface CategoryService {
        List<CategoryDto> getAllCategory();
        List<ProductDto> getProductsByCategory(String name);
}
