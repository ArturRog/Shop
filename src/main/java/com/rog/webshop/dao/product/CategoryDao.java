package com.rog.webshop.dao.product;

import com.rog.webshop.model.product.Category;

import java.util.List;

public interface CategoryDao {

    void save(Category category);
    List<Category> getAll();
    Category getByName(String name);
    Category findById(int id);
}
