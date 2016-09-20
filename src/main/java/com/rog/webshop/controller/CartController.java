package com.rog.webshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

    @Controller
    @RequestMapping(value = "/cart")
    public class CartController {

        @RequestMapping(value = "/getCartId", method = RequestMethod.GET)
        public
        @ResponseBody
        String getCartId(HttpServletRequest request) {
            return request.getSession().getId();
        }


        @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
        public String getCart(@PathVariable(value = "cartId") String cartId , ModelMap model){
            model.addAttribute("cartId", cartId);
            return "cart";
        }

        @RequestMapping
        public String get(HttpServletRequest request){
            return "redirect:/cart/" + request.getSession(true).getId();
        }



    }
