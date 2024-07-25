package com.project.model;

public class Address {
    private long Id;
    private String name;
    private final long flatNo;

    private final String buildingName;
    private String street;
    private String city;
    private long pinCode;
    private String state;


    public Address(long id, String name, long flatNo, String buildingName, String street, String city, String state, long pinCode) {
        this.Id = id;
        this.name = name;
        this.flatNo = flatNo;
        this.buildingName = buildingName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFlatNo() {
        return flatNo;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }
}
