package dev.shivan.fakestoreimpl.service;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import dev.shivan.fakestoreimpl.Model.Category;
import dev.shivan.fakestoreimpl.Model.Product;
import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.repository.CategoryRepository;
import dev.shivan.fakestoreimpl.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{ 

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
        public Product convertProductDtotoProduct(ProductDto productDto,Category category)
        {
            Product product = new Product();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setTitle(productDto.getTitle());
            product.setImage(productDto.getImage());
            product.setDescription(productDto.getDescription());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            return product;
        }
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public List<ProductDto> getAllProducts()
    {
        return null;
    }
    public ProductDto createProduct(ProductDto productDto)
    {
        Category category;
        Optional<Category> categoryOptional= categoryRepository.findByName(productDto.getCategory());
        if(categoryOptional.isEmpty())
        {
            category = new Category();
            category.setName(productDto.getCategory());
        }else
        {
            category = categoryOptional.get();
        }
        Product product = convertProductDtotoProduct(productDto,category);
        System.out.println(product.getPrice());
        Product returnProduct = productRepository.save(product);
        return convertProductToProductDto(returnProduct);
    }
    
}
