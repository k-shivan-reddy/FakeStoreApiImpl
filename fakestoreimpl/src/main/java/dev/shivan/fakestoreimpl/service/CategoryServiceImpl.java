package dev.shivan.fakestoreimpl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.shivan.fakestoreimpl.Model.Category;
import dev.shivan.fakestoreimpl.Model.Product;
import dev.shivan.fakestoreimpl.dto.CategoryDto;
import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.exceptions.NotFoundException;
import dev.shivan.fakestoreimpl.repository.CategoryRepository;
import dev.shivan.fakestoreimpl.repository.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService
{
            public CategoryDto convertCategoryToCategoryDto(Category category) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setName(category.getName());
                return categoryDto;
        }

        public ProductDto convertProductToProductDto(Product product) {

            ProductDto productDto = new ProductDto();
            productDto.setImage(product.getImage());
            productDto.setDescription(product.getDescription());
            productDto.setTitle(product.getTitle());
            productDto.setPrice(product.getPrice());
            productDto.setCategory(product.getCategory().getName());
            productDto.setId(product.getId());
            return productDto;
            }
            CategoryRepository categoryRepository;
            ProductRepository productRepository;
            CategoryServiceImpl(CategoryRepository categoryRepository,ProductRepository productRepository)
            {
                this.categoryRepository = categoryRepository;
                this.productRepository = productRepository;
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

            public List<ProductDto> getProductsByCategory(String name) throws NotFoundException
            {

                Optional<Category> categoryOptional = categoryRepository.getCategoryByName(name);
                if(categoryOptional.isEmpty())
                {
                    throw new NotFoundException("Category with this name is not possible  :  "+name);
                }
                List<Product> listProducts = categoryOptional.get().getProducts();
                List<ProductDto> listpProductDtos = new ArrayList<>();
                for(Product product:listProducts)
                {
                    listpProductDtos.add(convertProductToProductDto(product));
                }
                return listpProductDtos;
            }
}
