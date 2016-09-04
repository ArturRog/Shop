package com.rog.webshop.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products in indicated category.")
public class NoProductsFoundUnderCategoryException extends RuntimeException {


    private static final long serialVersionUID = -995285473393456792L;
}
