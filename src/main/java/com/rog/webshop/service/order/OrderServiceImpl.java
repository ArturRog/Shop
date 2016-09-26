package com.rog.webshop.service.order;

import com.rog.webshop.dao.cart.CartDao;
import com.rog.webshop.dao.order.OrderDao;
import com.rog.webshop.model.cart.Item;
import com.rog.webshop.model.order.Order;
import com.rog.webshop.model.product.Product;
import com.rog.webshop.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartDao cartDao;

    public void save(Order order) {

        List<Product> products = new ArrayList<Product>();
        for (Item item : order.getCart().getProducts().values()) {
            products.add(item.getProduct());
        }

        order.setProductList(products);

        cartDao.delete(order.getCart().getCartId());
        orderDao.save(order);
    }

    public Order findById(int orderId) {
        return orderDao.findById(orderId);
    }

    public List<Order> findByUser(User user) {
        return orderDao.findByUser(user);
    }

    public List<Order> listOfOrders() {
        return orderDao.listOfOrders();
    }
}
