package com.project.model;

public class Contact {
    private long id;
    private long phone;
    private Address address;

    public Contact(long id, long phone, Address address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
