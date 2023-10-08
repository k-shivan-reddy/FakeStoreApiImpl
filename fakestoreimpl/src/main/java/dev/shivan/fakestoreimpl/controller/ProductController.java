package dev.shivan.fakestoreimpl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.shivan.fakestoreimpl.dto.ProductDto;
import dev.shivan.fakestoreimpl.service.ProductService;

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
    public String getAllProducts()
    {
        return "test";
      // return productService.getAllProducts();
    }

    @PostMapping()
    public ProductDto addProduct(@RequestBody ProductDto product)
    {
        return productService.createProduct(product);
    }
    
}
