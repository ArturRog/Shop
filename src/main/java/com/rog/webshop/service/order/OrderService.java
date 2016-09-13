package com.rog.webshop.service.order;

import com.rog.webshop.model.order.Order;

public interface OrderService {
    void processOrder(String productId, long quantity);

    int saveOrder(Order order);
}
