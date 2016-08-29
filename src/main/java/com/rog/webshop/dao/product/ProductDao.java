package com.rog.webshop.dao.product;

import com.rog.webshop.model.product.Product;

import java.util.List;

public interface ProductDao {

    Product findById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    List<Product> listOfProducts();
    List<Product> findByCategory(String category);
    void removeProduct(int id);

}
