package com.project.model;

import javax.swing.text.html.parser.Entity;

public class Menu {
    private long id;
    private String name;
    private String description;
    private double price;
    private Restaurant restaurant;
    private String cuisine;
    private boolean isVegetarian;

    public Menu(long id, String name, String description, double price, Restaurant restaurant, String cuisine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
        this.cuisine = cuisine;
        this.isVegetarian = isVegetarian;
    }

    public Menu(int id, String pepperoniPizza, String deliciousPepperoniPizza, double price, Entity restaurantEntity, String inStock) {
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
    public boolean isVegetarian() { return isVegetarian; }
    public void setVegetarian(boolean isVegetarian) { this.isVegetarian = isVegetarian; }

    public String getState() {
        return getState();}

    public boolean isAvailability() {
        return isAvailability();
    }
}
