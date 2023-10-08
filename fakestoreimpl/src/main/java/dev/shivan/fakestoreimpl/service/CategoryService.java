package dev.shivan.fakestoreimpl.service;

import java.util.List;

import dev.shivan.fakestoreimpl.dto.CategoryDto;
import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.exceptions.NotFoundException;

public interface CategoryService {
        List<CategoryDto> getAllCategory();
        List<ProductDto> getProductsByCategory(String name) throws NotFoundException;
}
