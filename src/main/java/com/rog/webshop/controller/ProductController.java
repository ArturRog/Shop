package com.rog.webshop.controller;


import com.rog.webshop.model.product.Category;
import com.rog.webshop.model.product.Product;
import com.rog.webshop.service.product.CategoryService;
import com.rog.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping
    public String showProducts(ModelMap model, @RequestParam(value = "category", required = false) String nameOrNull) {


        System.out.println(nameOrNull);
        if (nameOrNull != null) {
            model.addAttribute("products", productService.findByCategory(Integer.parseInt(nameOrNull)));
        } else {
            model.addAttribute("products", productService.listOfProducts());
        }

        return "products";
    }

    @RequestMapping(value = "/product")
    public String showProduct(ModelMap model, @RequestParam(value = "id", required = true) int productId) {

        model.addAttribute("product", productService.findById(productId));

        return "product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(ModelMap model) {
        Product product = new Product();
        model.addAttribute("newProduct", product);
        return "addProduct";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {

        System.out.println("Product name: " + newProduct.getProductName());
        System.out.println("Product price: " + newProduct.getProductPrice());
        System.out.println("Product description: " + newProduct.getProductDescription());
        System.out.println("Product category: " + newProduct.getCategory());

        if (result.hasErrors()) {
            System.out.println("There are errors" + result.getAllErrors());
            return "redirect:/products";
        }

        productService.addProduct(newProduct);

        return "redirect:/products";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String showProductsWithCategory(ModelMap model, @RequestParam(value = "category", required = true) String name){
//
//        System.out.println(name);
//        model.addAttribute("products", productService.findByCategory(name));
//
//        return "products";
//    }

    @ModelAttribute("categories")
    public List<Category> initializeProfiles() {
        return categoryService.getAll();

    }


}
