package com.example.ex1_manager_product_thymeleaf.services.impl;

import com.example.ex1_manager_product_thymeleaf.models.Product;
import com.example.ex1_manager_product_thymeleaf.repositories.ProductRepository;
import com.example.ex1_manager_product_thymeleaf.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        productRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
