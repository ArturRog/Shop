package com.rog.webshop.model.order;

import com.rog.webshop.model.cart.Cart;
import com.rog.webshop.model.user.User;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = -167040897500768764L;
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Cart cart;
    private User user;
    private ShippingDetail shippingDetail;

    public Order() {
        this.user = new User();
        this.shippingDetail = new ShippingDetail();
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", cart=" + cart +
                ", user=" + user +
                ", shippingDetail=" + shippingDetail +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (cart != null ? !cart.equals(order.cart) : order.cart != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        return shippingDetail != null ? shippingDetail.equals(order.shippingDetail) : order.shippingDetail == null;

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (shippingDetail != null ? shippingDetail.hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }
}
