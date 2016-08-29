package com.rog.webshop.dao.product;

import com.rog.webshop.dao.AbstractDao;
import com.rog.webshop.model.product.Category;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<String, Category> implements CategoryDao {

    public void save(Category category) {
        persist(category);

    }

    public List<Category> getAll() {
        return findAll();
    }

    public Category getByName(String name) {
        return getByKey(name);

    }
}
