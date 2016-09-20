package com.rog.webshop.controller;


import com.rog.webshop.model.cart.Cart;
import com.rog.webshop.model.cart.Item;
import com.rog.webshop.model.product.Product;
import com.rog.webshop.service.cart.CartService;
import com.rog.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    /**
     * POST - Creates new Cart object
     * GET - Sends Cart object with id = cartId
     * PUT - Updates Cart object with id = cartId
     * DELETE - Delete Cart object with id  = cartId
     */

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }


    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartService.update(cart, cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }


    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable Integer productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }
        Product product = productService.findById(productId);
        if (product == null) {
            throw new IllegalArgumentException();
        }
        cart.addItemToCart(new Item(product));
        cartService.update(cart, sessionId);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable Integer productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }
        Product product = productService.findById(productId);
        if (product == null) {
            throw new IllegalArgumentException();
        }
        cart.removeItem(new Item(product));
        cartService.update(cart, sessionId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Incorrect request, check request data")
    public void handleClientErrors(Exception ex) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handleServerErrors(Exception ex) {
    }

}
