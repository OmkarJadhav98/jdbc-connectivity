package com.project.model;

import java.util.List;

public class Restaurant {
    private long id;
    private String name;
    private Address address;

    public Restaurant(long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant(long id, String name, Contact contact, List<Menu> menus) {
    }

    public Restaurant(int id, String pizzaPlace, String s, String s1) {

    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Object getContact() { return getContact();
    }

    public void setMenuItems(List<Menu> menuItems) {
    }
}
