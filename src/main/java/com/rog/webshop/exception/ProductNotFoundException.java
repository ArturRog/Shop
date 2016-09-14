package com.rog.webshop.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 644654617801857838L;

    private Integer productId;
    public ProductNotFoundException(Integer productId){
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }
}
