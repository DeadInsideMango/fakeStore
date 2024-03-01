package com.example.fakeStore.repository;

import java.util.List;

public interface ProductsRepository {

    public List<Object> getAllProducts();
    public List<Object> getSingleProduct(Long id);

}
