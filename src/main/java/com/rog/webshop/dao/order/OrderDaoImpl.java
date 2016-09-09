package com.rog.webshop.dao.order;

import com.rog.webshop.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {

    private Map<Long,Order> listOfOrders;
    private long nextOrderId;

    public OrderDaoImpl() {
        this.listOfOrders = new HashMap<Long, Order>();
        this.nextOrderId = 1000;
    }

    public Long saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();

    }

    private synchronized long getNextOrderId(){
        return nextOrderId++;
    }
}
