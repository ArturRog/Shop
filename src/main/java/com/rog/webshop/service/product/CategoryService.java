package com.rog.webshop.service.product;

import com.rog.webshop.model.product.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);
    List<Category> getAll();
    Category getByName(String name);
    Category findById(int id);
}
