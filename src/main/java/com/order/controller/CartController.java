package com.order.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.model.Cart;
import com.order.model.Customer;
import com.order.model.Product;
import com.order.service.ProductService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, HttpSession session) {

        Customer cust = (Customer) session.getAttribute("LOGGED_IN_USER");
        Product product = productService.getProduct(productId);

        List<Cart> cart = cust.getCart();

        // If cart is null → create it
        if (cart == null) {
            cart = new ArrayList<>();
            Cart item = new Cart(product.getId(), product.getName(),
                    product.getPrice(), 1, product.getPrice());
            cart.add(item);
            cust.setCart(cart);
            return "redirect:/products/catPd";
        }

        // If cart exists → check if product already there
        for (Cart c : cart) {
            if (c.getId().equals(productId)) {
                c.setQuantity(c.getQuantity() + 1);
                c.setTotalPrice(c.getPrice() * c.getQuantity());
                return "redirect:/products/catPd";
            }
        }

        // Product not found → add new item
        Cart item = new Cart(product.getId(), product.getName(),
                product.getPrice(), 1, product.getPrice());
        cart.add(item);
        return "redirect:/products/catPd";
    }

    @GetMapping("/mycart")
    public String showCart(HttpSession session, Model model) {
        Customer user = (Customer) session.getAttribute("LOGGED_IN_USER");

        if (user == null) {
            return "redirect:/order/login";
        }

        model.addAttribute("name", user.getName());
        model.addAttribute("cartItems", user.getCart());

        model.addAttribute("newProduct", user.getCart()==null?null:user.getCart().get(user.getCart().size()-1).getpName());

        // add cart items here
        return "cart-page";
    }
    @PostMapping("/decrease")
    public String minusItem(@RequestParam Long productID,HttpSession session,Model model) {
        Customer user = (Customer) session.getAttribute("LOGGED_IN_USER");
         if (user == null) {
            return "redirect:/order/login";
        }
        List<Cart> custCart=user.getCart();

        Iterator<Cart> iterator=custCart.iterator();

        while(iterator.hasNext()) {
            Cart c=iterator.next();
            if (c.getId().equals(productID)) {
                if(c.getQuantity()<=1){
                    custCart.remove(c);
                }
                else{
                    c.setQuantity(c.getQuantity()-1);
                    c.setTotalPrice(c.getPrice()*c.getQuantity());
                }
                break;
            }
             
        }
        
        model.addAttribute("name", user.getName());
        model.addAttribute("cartItems", user.getCart());
        
        return "cart-page";
    }
    

}
