package com.rog.webshop.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 644654617801857838L;

    private String productId;
    public ProductNotFoundException(String productId){
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
