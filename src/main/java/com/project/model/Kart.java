package com.project.model;

import java.util.List;

public class Kart {
    private long id;
    private List<Menu> selectedMenus;
    private double finalPrice;
    private Customer customer;
    private Restaurant restaurant;

    public Kart(long id, List<Menu> selectedMenus, double finalPrice, Customer customer, Restaurant restaurant) {
        this.id = id;
        this.selectedMenus = selectedMenus;
        this.finalPrice = finalPrice;
        this.customer = customer;
        this.restaurant = restaurant;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public List<Menu> getSelectedMenus() { return selectedMenus; }
    public void setSelectedMenus(List<Menu> selectedMenus) { this.selectedMenus = selectedMenus; }
    public double getFinalPrice() { return finalPrice; }
    public void setFinalPrice(double finalPrice) { this.finalPrice = finalPrice; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
}
