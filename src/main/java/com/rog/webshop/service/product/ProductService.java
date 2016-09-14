package com.rog.webshop.service.product;

import com.rog.webshop.model.product.Product;

import java.util.List;

public interface ProductService {

    Product findById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    List<Product> listOfProducts();
    List<Product> findByCategory(String category);
    void removeProduct(Product product);
}
