package com.example.fakeStore.services;

import com.example.fakeStore.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService implements CategoryRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Object> getAllCategories() {
        String url = "https://fakestoreapi.com/products/categories";
        Object[] listOfAllCategories = restTemplate.getForObject(url, Object[].class);
        if (listOfAllCategories == null) return Collections.emptyList();
        return List.of(listOfAllCategories);
    }

    @Override
    public List<Object> getAllProductsInSpecificCategory(String category) {
        String url = "https://fakestoreapi.com/products/categories/" + category;
        Object[] allProductsInSpecificCategory = restTemplate.getForObject(url, Object[].class);
        if(allProductsInSpecificCategory == null) return Collections.emptyList();
        return List.of(allProductsInSpecificCategory);
    }
}
