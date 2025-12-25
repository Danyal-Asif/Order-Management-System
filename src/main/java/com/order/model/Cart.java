package com.order.model;

public class Cart {
    private String pName;
    private double price;
    private int quantity;
    private double total;

    
    public Cart(String pName, double price, int quantity, double total) {
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    

}
