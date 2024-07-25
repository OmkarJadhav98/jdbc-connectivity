package com.project.model;

public class Customer {
    private long id;
    private String name;
    private String email;
    private Contact contact;

    public Customer(long id, String name, String email, Contact contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Contact getContact() { return contact; }
    public void setContact(Contact contact) { this.contact = contact; }

    public boolean getUsername() { return getUsername();
    }
}
