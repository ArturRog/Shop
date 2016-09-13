package com.rog.webshop.model.order;

import com.rog.webshop.model.cart.Cart;
import com.rog.webshop.model.user.User;

import java.io.Serializable;


//@Entity
//@Table(name = "ORDER")
public class Order implements Serializable {

    private static final long serialVersionUID = -167040897500768764L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private Cart cart;

//    @OneToOne
    private User user;

//    @OneToOne
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

        if (orderId != order.orderId) return false;
        if (cart != null ? !cart.equals(order.cart) : order.cart != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (shippingDetail != null ? !shippingDetail.equals(order.shippingDetail) : order.shippingDetail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (shippingDetail != null ? shippingDetail.hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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
