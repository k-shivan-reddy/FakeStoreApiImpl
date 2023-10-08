package dev.shivan.fakestoreimpl.controller;


import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.shivan.fakestoreimpl.dto.*;
import dev.shivan.fakestoreimpl.service.CategoryService;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;
    CategoryController(CategoryService categoryService)
    {
        this.categoryService =categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategory()
    {
        return categoryService.getAllCategory();
    }

    @GetMapping
    public List<ProductDto> getAllProductOfCategory(@PathVariable("name") String name)
    {
        return categoryService.getProductsByCategory(name);
    }
}
