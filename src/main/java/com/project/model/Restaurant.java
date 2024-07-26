package com.project.model;

import java.util.List;

public class Restaurant {
    private long id;
    private String name;
    private Contact contact;
    private List<Menu> menus;

    public Restaurant(long id, String name, Contact contact, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.menus = menus;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
