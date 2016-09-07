package com.rog.webshop.dao.cart;

import com.rog.webshop.model.cart.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository("cartDao")
public class CartDaoImpl implements CartDao {


    private Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        System.out.println("I'm in create method in Cart DAO. cart: " + cart.getCartId());

        if (listOfCarts.containsKey(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Can not create cart"
                    + "Cart with specified id (%) already exists.", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId) {
        System.out.println("I'm in read method in Cart DAO. cartId: " + cartId);
        return listOfCarts.get(cartId);
    }


    public void update(Cart cart, String cartId) {
        System.out.println("I'm in update method in Cart DAO. cart: " + cart.getCartId() + " cartID" + cartId);

        if (!listOfCarts.containsKey(cartId)) {
            throw new IllegalArgumentException(String.format("Can not update cart. "
                    + "Cart with specified id (%) does not exists.", cartId));
        }
        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId) {
        System.out.println("I'm in create method in Cart DAO. cartId: " + cartId);

        if (!listOfCarts.containsKey(cartId)) {
            throw new IllegalArgumentException(String.format("Can not update cart. "
                    + "Cart with specified id (%) does not exists.", cartId));
        }
        listOfCarts.remove(cartId);
    }
}
