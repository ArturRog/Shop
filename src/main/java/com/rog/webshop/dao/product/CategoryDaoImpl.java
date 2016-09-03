package com.rog.webshop.dao.product;

import com.rog.webshop.dao.AbstractDao;
import com.rog.webshop.model.product.Category;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

    public void save(Category category) {
        persist(category);

    }

    public Category findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Category> getAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("id"));
        return (List<Category>)crit.list();
    }

    public Category getByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("categoryName", name));
        return (Category) crit.uniqueResult();

    }
}
