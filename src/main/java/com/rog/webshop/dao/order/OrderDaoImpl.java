package com.rog.webshop.dao.order;

import com.rog.webshop.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {

    private Map<Integer,Order> listOfOrders;
    private int nextOrderId;

    public OrderDaoImpl() {
        this.listOfOrders = new HashMap<Integer, Order>();
        this.nextOrderId = 1000;
    }

    public int saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();

    }

    private synchronized int getNextOrderId(){
        return nextOrderId++;
    }
}
