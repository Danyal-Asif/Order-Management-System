package com.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.model.Customer;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId,HttpSession session) {
        Map<Long,Integer> cart=(Map<Long,Integer>)session.getAttribute("CART");
        if(cart==null){
            cart=new HashMap<Long,Integer>();
        }
        cart.put(productId,cart.getOrDefault(productId, 0)+1);
        session.setAttribute("CART", cart);
        Customer cust=(Customer)session.getAttribute("LOGGED_IN_USER");

        System.out.println("User : "+cust.getName()+"\n"+
    "Product Quantity : "+cart.toString()
    );

        return "redirect:/products/catPd";
    }
    
}
