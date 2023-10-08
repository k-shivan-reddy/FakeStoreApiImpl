package dev.shivan.fakestoreimpl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.shivan.fakestoreimpl.Model.Category;
import dev.shivan.fakestoreimpl.Model.Product;
import dev.shivan.fakestoreimpl.dto.CategoryDto;
import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService
{
            public CategoryDto convertCategoryToCategoryDto(Category category) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setName(category.getName());
                return categoryDto;
        }
            CategoryRepository categoryRepository;
            CategoryServiceImpl(CategoryRepository categoryRepository)
            {
                this.categoryRepository = categoryRepository;
            }
            @Override
            public List<CategoryDto> getAllCategory()
            {
                List<Category> listCategory = categoryRepository.findAll();
                List<CategoryDto> listCategoryDtos = new ArrayList<>();
                for(Category category:listCategory)
                {
                    listCategoryDtos.add(convertCategoryToCategoryDto(category));
                }
                return listCategoryDtos;
            }
            
            public List<ProductDto> getProductsByCategory(String name)
            {
                return null;
            }
}
