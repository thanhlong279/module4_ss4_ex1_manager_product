package com.example.ex1_manager_product_thymeleaf.services;

import com.example.ex1_manager_product_thymeleaf.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(long id);

    void deleteById(long id);

    void update(Product product);
}
