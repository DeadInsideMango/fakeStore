package com.example.fakeStore.services;

import com.example.fakeStore.repository.ProductsRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements ProductsRepository {

    @Override
    public List<Object> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = new RestTemplate();
        Object[] products = restTemplate.getForObject(url, Object[].class);
        if(products != null) return Arrays.asList(products);
        else return null;
    }

    @Override
    public List<Object> getSingleProduct(@NotNull Long id) {
        String idAsString = id.toString();
        String url = "https://fakestoreapi.com/products/" + idAsString;
        RestTemplate restTemplate = new RestTemplate();
        Object[] product = restTemplate.getForObject(url, Object[].class);
        if(product != null) return Arrays.asList(product);
        else return null;
    }
}
