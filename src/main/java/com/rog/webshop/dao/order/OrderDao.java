package com.rog.webshop.dao.order;

import com.rog.webshop.model.order.Order;

import java.util.List;

public interface OrderDao {

    void save(Order order);

    Order findById(int orderId);

    List<Order> listOfOrders();
}
