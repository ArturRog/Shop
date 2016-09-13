package com.rog.webshop.dao.order;

import com.rog.webshop.model.order.Order;

public interface OrderDao {
    int saveOrder(Order order);
}
