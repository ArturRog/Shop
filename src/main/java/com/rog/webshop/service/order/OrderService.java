package com.rog.webshop.service.order;

import com.rog.webshop.model.order.Order;
import com.rog.webshop.model.user.User;

import java.util.List;

public interface OrderService {
//    void processOrder(String productId, long quantity);
//
//    int saveOrder(Order order);

    void save(Order order);

    Order findById(int orderId);

    List<Order> listOfOrders();
    List<Order> findByUser(User user);
}
