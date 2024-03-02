package com.example.fakeStore.services;

import com.example.fakeStore.repository.ProductsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService implements ProductsRepository {
    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Object> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        Object[] allProducts = restTemplate.getForObject(url, Object[].class);
        if(allProducts == null) return Collections.emptyList();
        return List.of(allProducts);
    }

    @Override
    public List<Object> getProductById(String id) {
        String url = "https://fakestoreapi.com/products/".concat(id);
        Object singleProduct = restTemplate.getForObject(url, Object.class);
        if (singleProduct == null) return Collections.emptyList();
        return List.of(singleProduct);
    }

}
