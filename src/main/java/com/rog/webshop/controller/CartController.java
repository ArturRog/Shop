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
            System.out.println("I'm in getCartId method in /rest/cart controller. Session id: " + request.getSession(true).getId());

            return request.getSession().getId();
        }


        @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
        public String getCart(@PathVariable(value = "cartId") String cartId , ModelMap model){
            System.out.println("I'm in getCart method in /cart controller. CartId: " + cartId);

            model.addAttribute("cartId", cartId);
            return "cart";
        }

        @RequestMapping
        public String get(HttpServletRequest request){
            System.out.println("I'm in get method in /cart controller. Session id: " + request.getSession(true).getId() );


            return "redirect:/cart/" + request.getSession(true).getId();
        }



    }
