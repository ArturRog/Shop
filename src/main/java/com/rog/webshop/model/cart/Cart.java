package com.rog.webshop.model.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {

    private static final long serialVersionUID = 6963354675862881135L;

    private String cartId;
    private Map<Integer, Item> products;
    private BigDecimal totalValue;

    public Cart() {
        this.products = new HashMap<Integer, Item>();
        this.totalValue = new BigDecimal(0);
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }


    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, Item> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Item> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalValue;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalValue = totalPrice;
    }

    @Override
    public String toString() {
        return "CartDao{" +
                "cartId='" + cartId + '\'' +
                ", products=" + products +
                ", totalValue=" + totalValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != null ? !cartId.equals(cart.cartId) : cart.cartId != null) return false;
        if (products != null ? !products.equals(cart.products) : cart.products != null) return false;
        return totalValue != null ? totalValue.equals(cart.totalValue) : cart.totalValue == null;

    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (totalValue != null ? totalValue.hashCode() : 0);
        return result;
    }

    public void addItemToCart(Item item) {
        System.out.println("I'm in addItemToCart method in Cart model controller. Item to be added: " + item.getProduct().getId());

        Integer itemId = item.getProduct().getId();

        if (products.containsKey(itemId)) {
            Item alreadyInCart = products.get(itemId);
            alreadyInCart.setQuantity(alreadyInCart.getQuantity() + item.getQuantity());
            products.put(itemId, alreadyInCart);
        } else {
            products.put(itemId, item);
        }
        updateTotalValue();
    }

    public void updateTotalValue() {
        totalValue = new BigDecimal(0);
        for (Item item : products.values()) {
            totalValue = totalValue.add(item.getTotalValue());
        }
    }

    public void removeItem(Item item) {
        products.remove(item.getProduct().getId());
        updateTotalValue();

    }

}
