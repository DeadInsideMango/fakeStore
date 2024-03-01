package com.example.fakeStore.controllers;

import com.example.fakeStore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    private List<Object> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    private List<Object> getSingleProduct(@PathVariable Long id) {
        return productService.getSingleProduct(id);
    }

}
