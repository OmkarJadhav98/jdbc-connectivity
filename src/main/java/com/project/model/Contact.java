package com.project.model;

public class Contact {
    private int id;
    private String phone;
    private Address address;

    public Contact(int id, String phone, Address address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
