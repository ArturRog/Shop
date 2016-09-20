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

        return cartDao.create(cart);
    }

    public Cart read(String cartId) {

        return cartDao.read(cartId);
    }

    public void update(Cart cart, String cartId) {
        cartDao.update(cart, cartId);
    }

    public void delete(String cartId) {
        cartDao.delete(cartId);
    }
}
