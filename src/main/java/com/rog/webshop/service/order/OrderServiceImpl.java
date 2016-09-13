package com.rog.webshop.service.order;

import com.rog.webshop.dao.cart.CartDao;
import com.rog.webshop.dao.order.OrderDao;
import com.rog.webshop.dao.product.ProductDao;
import com.rog.webshop.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    public void processOrder(String productId, long quantity) {

    }

    public int saveOrder(Order order) {
        int orderId =  orderDao.saveOrder(order);
        cartDao.delete(order.getCart().getCartId());
        return orderId;
    }
}
