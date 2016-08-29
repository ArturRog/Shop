package com.rog.webshop.controller;


import com.rog.webshop.service.product.CategoryService;
import com.rog.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping
    public String showProducts(ModelMap model, @RequestParam(value = "category", required = false) String nameOrNull){

        System.out.println(nameOrNull);
        if (nameOrNull != null){
            model.addAttribute("products", productService.findByCategory(nameOrNull));
        }
        else{
            model.addAttribute("products", productService.listOfProducts());
        }

        return "products";
    }

    @RequestMapping(value = "/product")
    public String showProduct(ModelMap model, @RequestParam(value = "id", required = true) int productId){

        model.addAttribute("product", productService.findById(productId));

        return "product";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String showProductsWithCategory(ModelMap model, @RequestParam(value = "category", required = true) String name){
//
//        System.out.println(name);
//        model.addAttribute("products", productService.findByCategory(name));
//
//        return "products";
//    }


}
