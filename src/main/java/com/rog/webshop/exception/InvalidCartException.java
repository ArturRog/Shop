package com.rog.webshop.exception;

public class InvalidCartException extends RuntimeException {

    private static final long serialVersionUID = 568800540411028177L;

    private String cartId;
    public InvalidCartException(String cartId){
        this.cartId = cartId;

    }

    public String getCartId(){
        return cartId;
    }
}
