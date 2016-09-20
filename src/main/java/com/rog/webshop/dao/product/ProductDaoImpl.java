package com.rog.webshop.dao.product;

import com.rog.webshop.dao.AbstractDao;
import com.rog.webshop.model.product.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {


    public Product findById(int id) {
        return getByKey(id);
    }

    public void addProduct(Product product) {
        persist(product);

    }

    public void updateProduct(Product product) {
        update(product);
    }

    public List<Product> listOfProducts() {
        return findAll();
    }


    @SuppressWarnings("unchecked")
    public List<Product> findByCategory(Integer category) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("category.id", category));
        return (List<Product>) criteria.list();
    }

    public void removeProduct(Product product) {
        delete(product);
    }
}
