package com.rog.webshop.controller;


import com.rog.webshop.exception.NoProductsFoundUnderCategoryException;
import com.rog.webshop.exception.ProductNotFoundException;
import com.rog.webshop.model.product.Category;
import com.rog.webshop.model.product.Product;
import com.rog.webshop.model.user.UserProfile;
import com.rog.webshop.service.product.CategoryService;
import com.rog.webshop.service.product.ProductService;
import com.rog.webshop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;


    @RequestMapping
    public String showProducts(ModelMap model, @RequestParam(value = "category", required = false) String nameOrNull) {

        if (nameOrNull != null) {
            if (productService.findByCategory(nameOrNull).isEmpty()) {
                throw new NoProductsFoundUnderCategoryException();
            }
            model.addAttribute("products", productService.findByCategory(nameOrNull));
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
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result) {


        if (result.hasErrors()) {
            System.out.println("There are errors" + result.getAllErrors());
            return "addProduct";
        }
        String[] supressedFields = result.getSuppressedFields();
        if (supressedFields.length > 0) {
            throw new RuntimeException("Trial of binding supressed fields: "
                    + StringUtils.arrayToCommaDelimitedString(supressedFields));
        }


        productService.addProduct(newProduct);

        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEditProductForm(Model model, @PathVariable("id") Integer productId)
    {
        Product newProduct = productService.findById(productId);
        if(newProduct==null)
        {
            throw new ProductNotFoundException(productId);
        }
        model.addAttribute("newProduct", newProduct);
        return "editProduct";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String processEditProductForm(@ModelAttribute @Valid Product newProduct,
                                         @PathVariable("id") Integer productId,
                                         BindingResult result)
    {
        if(result.hasErrors())
        {
            return "edit/"+newProduct.getId();
        }
        String[] supressedFields = result.getSuppressedFields();
        if(supressedFields.length>0)
        {
            throw new RuntimeException("Trial of binding supressed fields: "
                    +StringUtils.arrayToCommaDelimitedString(supressedFields));
        }
        newProduct.setId(productId);
        productService.updateProduct(newProduct);
        return "redirect:/products";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeProduct(Model model, @PathVariable("id") int productId)
    {
        Product deletedProduct = productService.findById(productId);
        if(deletedProduct==null)
        {
            throw new ProductNotFoundException(productId);
        }
        productService.removeProduct(deletedProduct);
        return "redirect:/products";
    }

    @ModelAttribute("categories")
    public List<Category> initializeProfiles() {
        return categoryService.getAll();

    }
    public boolean isAdmin() {

        Set<UserProfile> isAdmin = userService.findBySso(getPrincipal()).getUserProfiles();
        for (UserProfile userProfile : isAdmin) {
            if (userProfile.getType().equals("ADMIN"))
                return true;
        }
        return false;
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("id", "categoryName", "productName", "productPrice", "productDescription", "category");
    }

}
