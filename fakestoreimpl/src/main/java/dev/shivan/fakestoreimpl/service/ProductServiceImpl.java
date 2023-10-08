package dev.shivan.fakestoreimpl.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.shivan.fakestoreimpl.Model.Category;
import dev.shivan.fakestoreimpl.Model.Product;
import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.repository.CategoryRepository;
import dev.shivan.fakestoreimpl.repository.ProductRepository;
import jakarta.transaction.Transactional;
import dev.shivan.fakestoreimpl.exceptions.NotFoundException;

@Service
public class ProductServiceImpl implements ProductService{ 

        public ProductDto convertProductToProductDto(Product product) {

        ProductDto ProductDto = new ProductDto();
        ProductDto.setImage(product.getImage());
        ProductDto.setDescription(product.getDescription());
        ProductDto.setTitle(product.getTitle());
        ProductDto.setPrice(product.getPrice());
        ProductDto.setCategory(product.getCategory().getName());
        ProductDto.setId(product.getId());
        return ProductDto;
        }
        public Product convertProductDtotoProduct(ProductDto ProductDto,Category category)
        {
            Product product = new Product();
            category.setName(ProductDto.getCategory());
            product.setCategory(category);
            product.setTitle(ProductDto.getTitle());
            product.setImage(ProductDto.getImage());
            product.setDescription(ProductDto.getDescription());
            product.setTitle(ProductDto.getTitle());
            product.setPrice(ProductDto.getPrice());
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
        List<Product> listProducts = productRepository.findAll();
        List<ProductDto> listpProductDtos = new ArrayList<>();
        for(Product product:listProducts)
        {
            listpProductDtos.add(convertProductToProductDto(product));
        }
        return listpProductDtos;
    }
    public ProductDto createProduct(ProductDto ProductDto)
    {
        Category category;
        Optional<Category> categoryOptional= categoryRepository.findByName(ProductDto.getCategory());
        if(categoryOptional.isEmpty())
        {
            category = new Category();
            category.setName(ProductDto.getCategory());
        }else
        {
            category = categoryOptional.get();
        }
        Product product = convertProductDtotoProduct(ProductDto,category);
        System.out.println(product.getPrice());
        Product returnProduct = productRepository.save(product);
        return convertProductToProductDto(returnProduct);
    }
    public ProductDto getProductbyId(int id) throws NotFoundException
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new NotFoundException("Product does not exist with id : " + id);
        }
        return convertProductToProductDto(product.get());
    }

        @Override
    @Transactional
    public ProductDto deleteProductById(int id)  throws NotFoundException{
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
        } else
        {
             throw new NotFoundException("Product does not exist with id : " + id);
        }
        return convertProductToProductDto(productOptional.get());

    }

    @Override
    public ProductDto updateProductById(int id, ProductDto ProductDto) throws NotFoundException{

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) 
        {
            Product existingProduct = productOptional.get();
            existingProduct.getCategory().setName(ProductDto.getCategory());
            existingProduct.setTitle(ProductDto.getTitle());
            existingProduct.setImage(ProductDto.getImage());
            existingProduct.setDescription(ProductDto.getDescription());
            existingProduct.setTitle(ProductDto.getTitle());
            existingProduct.setPrice(ProductDto.getPrice());
            Product returnproduct = productRepository.save(existingProduct);
            return convertProductToProductDto(returnproduct);

        } else
        {
            throw new NotFoundException("Product does not exist with id : " + id);
        }
    }

    
}
