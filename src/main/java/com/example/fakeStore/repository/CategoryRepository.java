package com.example.fakeStore.repository;

import java.util.List;

public interface CategoryRepository {

    List<Object> getAllCategories();
    List<Object> getAllProductsInSpecificCategory(String category);

}
