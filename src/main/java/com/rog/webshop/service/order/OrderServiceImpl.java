package com.rog.webshop.service.order;

import com.rog.webshop.dao.cart.CartDao;
import com.rog.webshop.dao.order.OrderDao;
import com.rog.webshop.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartDao cartDao;

    public void processOrder(String productId, long quantity) {

    }

    public Long saveOrder(Order order) {
        Long orderId =  orderDao.saveOrder(order);
        cartDao.delete(order.getCart().getCartId());
        return orderId;
    }
}
