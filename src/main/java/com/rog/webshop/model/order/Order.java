package com.rog.webshop.model.order;

import com.rog.webshop.model.user.User;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(name = "ORDER_DATE")
//    @NotEmpty
    private Date orderDate;

    //    @NotEmpty
//    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

//    @NotEmpty
//@ManyToOne(fetch = FetchType.LAZY)
    private User user;

//    private Cart cart;

    //    @OneToMany
    private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();


    public Order(){
    }

    public Order(Integer id, Date orderDate, BigDecimal totalPrice, User user, Set<OrderDetails> orderDetails) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", orderDetails=" + orderDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (totalPrice != null ? !totalPrice.equals(order.totalPrice) : order.totalPrice != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        return orderDetails != null ? orderDetails.equals(order.orderDetails) : order.orderDetails == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (orderDetails != null ? orderDetails.hashCode() : 0);
        return result;
    }
}
