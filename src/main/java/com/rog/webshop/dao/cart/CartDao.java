package com.rog.webshop.dao.cart;

import com.rog.webshop.model.cart.Cart;

public interface CartDao {

    Cart create(Cart cart);
    Cart read(String cartId);
    void update(Cart cart, String cartId);
    void delete(String cartId);
}
