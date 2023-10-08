package dev.shivan.fakestoreimpl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.exceptions.NotFoundException;
import dev.shivan.fakestoreimpl.service.ProductService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDto> getAllProducts()
    {
       return productService.getAllProducts();
    }
    @GetMapping("{id}")
    public ProductDto getProductsById(@PathVariable int id) throws NotFoundException
    {
       return productService.getProductbyId(id);
    }
    @PostMapping()
    public ProductDto addProduct(@RequestBody ProductDto product)
    {
        return productService.createProduct(product);
    }
    @DeleteMapping("{id}")
    public ProductDto getAllProductOfCategory(@PathVariable("id") int id) throws NotFoundException
    {
        return productService.deleteProductById(id);
    }
    @PutMapping(value="{id}")
    public ProductDto putMethodName(@PathVariable int id, @RequestBody ProductDto productDto) throws NotFoundException
    {
        return productService.updateProductById(id,productDto);
    }
}
