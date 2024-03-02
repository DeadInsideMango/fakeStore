package com.example.fakeStore.services;

import com.example.fakeStore.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService implements CategoryRepository {

    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Object> getAllCategories() {
        String url = "https://fakestoreapi.com/products/categories";
        return categoryServiceHelper(url);
    }

    @Override
    public List<Object> getAllProductsInSpecificCategory(String category) {
        String url = "https://fakestoreapi.com/products/category/".concat(category);
        return categoryServiceHelper(url);
    }

    private List<Object> categoryServiceHelper(String url) {
        Object[] listOfObjects = restTemplate.getForObject(url, Object[].class);
        if(listOfObjects == null) return Collections.emptyList();
        return List.of(listOfObjects);
    }

}
