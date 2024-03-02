package com.example.fakeStore.controllers;

import com.example.fakeStore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Object> getListOfAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{category}")
    public List<Object> getAllProductsInSpecificCategory(@PathVariable String category) {
        return categoryService.getAllProductsInSpecificCategory(category);
    }

}
