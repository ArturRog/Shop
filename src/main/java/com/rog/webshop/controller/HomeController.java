package com.rog.webshop.controller;


import com.rog.webshop.model.order.Order;
import com.rog.webshop.model.user.User;
import com.rog.webshop.model.user.UserProfile;
import com.rog.webshop.service.order.OrderService;
import com.rog.webshop.service.user.UserProfileService;
import com.rog.webshop.service.user.UserService;
import com.rog.webshop.validator.ValidateOnCreationOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//// TODO: 14.09.2016 walidacja w webflow
@Controller
public class HomeController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage() {
        return "redirect:/products";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }
    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String adminGetAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "adminUsersList";
    }

    @RequestMapping(value = "/myOrders", method = RequestMethod.GET)
    public String recentOrders(ModelMap model) {

        User user = userService.findBySso(getPrincipal());
        if (user == null) {
            throw new UsernameNotFoundException(getPrincipal());
        }

        List<Order> orders = isAdmin() ? orderService.listOfOrders() : orderService.findByUser(user);


        if (orders.isEmpty()) {
            model.addAttribute("noData", "There is no data to display.");
        }

        model.addAttribute("orders", orders);

        return "myOrders";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);

        return "newuser";
    }

    /*
     * This method will be called on form submission, handling POST request It
     * also validates the user input
     */
    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String saveRegistration(@Validated(ValidateOnCreationOnly.class) User user,
                                   BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "newuser";
        }

        if (user.getUserProfiles().isEmpty()) {
            Set<UserProfile> userProfiles = new HashSet<UserProfile>();
            userProfiles.add(userProfileService.findById(1));
            user.setUserProfiles(userProfiles);
        }


        userService.save(user);

        model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");


        return "registrationsuccess";
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


    public boolean isAdmin() {
        Set<UserProfile> isAdmin = userService.findBySso(getPrincipal()).getUserProfiles();
        for (UserProfile userProfile : isAdmin) {
            if (userProfile.getType().equals("ADMIN"))
                return true;
        }
        return false;
    }

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

}