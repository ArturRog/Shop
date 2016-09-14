package com.rog.webshop.dao.order;

import com.rog.webshop.dao.AbstractDao;
import com.rog.webshop.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractDao<Integer,Order> implements OrderDao {
    public void save(Order order) {
        persist(order);
    }
    private int getOrderId(){
        List<Order> orders = findAll();
        int highestId = 0;
        for (Order order : orders) {
            highestId = order.getOrderId();
            System.out.println("Co tu sie " + highestId);
        }
        return highestId;
    }

    public Order findById(int orderId) {
        return getByKey(orderId);
    }

    public List<Order> listOfOrders() {
        return findAll();
    }

//
//    private Map<Integer,Order> listOfOrders;
//    private int nextOrderId;
//
//    public OrderDaoImpl() {
//        this.listOfOrders = new HashMap<Integer, Order>();
//        this.nextOrderId = 1000;
//    }
//
//    public int saveOrder(Order order) {
//        order.setOrderId(getNextOrderId());
//        listOfOrders.put(order.getOrderId(), order);
//        return order.getOrderId();
//
//    }
//
//    private synchronized int getNextOrderId(){
//        return nextOrderId++;
//    }
}
