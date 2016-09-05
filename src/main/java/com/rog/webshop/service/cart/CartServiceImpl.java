package com.rog.webshop.service.cart;

import com.rog.webshop.dao.cart.CartDao;
import com.rog.webshop.model.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

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
