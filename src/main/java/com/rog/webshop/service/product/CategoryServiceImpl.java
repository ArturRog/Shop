package com.rog.webshop.service.product;

import com.rog.webshop.dao.product.CategoryDao;
import com.rog.webshop.model.product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void save(Category category) {
        categoryDao.save(category);
    }

    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    public Category getByName(String name) {
        return categoryDao.getByName(name);
    }

    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
