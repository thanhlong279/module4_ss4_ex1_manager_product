package com.example.ex1_manager_product_thymeleaf.repositories;

import com.example.ex1_manager_product_thymeleaf.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private static final List<Product> products;

    static {
        products = new ArrayList<Product>();
        products.add(new Product(1, "Iphone", 1000, 20));
        products.add(new Product(2, "SS", 800, 20));
        products.add(new Product(3, "Xiaomi", 400, 20));
        products.add(new Product(4, "Nokia", 100, 20));
    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        products.add(product);
    }

    public Product findById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void update(Product product) {
        for (Product productEdit : products) {
            if (productEdit.getId() == product.getId()) {
                productEdit.setPrice(product.getPrice());
                productEdit.setName(product.getName());
                productEdit.setQuantity(product.getQuantity());
            }
        }
    }

    public void delete(long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
    }
}
