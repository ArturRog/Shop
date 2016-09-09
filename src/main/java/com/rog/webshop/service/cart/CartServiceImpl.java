package com.rog.webshop.service.cart;

import com.rog.webshop.dao.cart.CartDao;
import com.rog.webshop.exception.InvalidCartException;
import com.rog.webshop.model.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart validate(String cartId) {
        Cart cart = cartDao.read(cartId);
        if (cart == null || cart.getProducts().size() == 0) {
            throw new InvalidCartException(cartId);

        }

        return cart;
    }

    public Cart create(Cart cart) {
        System.out.println("I'm in create method in Cart service. cart: " + cart.getCartId());

        return cartDao.create(cart);
    }

    public Cart read(String cartId) {

        System.out.println("I'm in read method in Cart service. cartId: " + cartId);
        return cartDao.read(cartId);
    }

    public void update(Cart cart, String cartId) {
        System.out.println("I'm in update in Cart service. cartId: " + cartId + " cart " + cart.getCartId());
        cartDao.update(cart, cartId);
    }

    public void delete(String cartId) {
        System.out.println("I'm in read delete in Cart service. cartId: " + cartId);
        cartDao.delete(cartId);
    }
}
