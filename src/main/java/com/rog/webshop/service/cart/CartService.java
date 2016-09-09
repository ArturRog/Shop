package com.rog.webshop.service.cart;

import com.rog.webshop.model.cart.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(Cart cart, String cartId);
    void delete(String cartId);
    Cart validate(String cartId);
}
