package com.rog.webshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {



    @RequestMapping()
    public String showCart(){return "cart";}

}
