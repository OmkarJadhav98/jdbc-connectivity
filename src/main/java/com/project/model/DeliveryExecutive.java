package com.project.model;

public class DeliveryExecutive {
    private long id;
    private String name;
    private long phoneNo;
    private boolean isAvailable;

    public DeliveryExecutive(long id, String name, long phoneNo, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getPhoneNo() { return phoneNo;}
    public void setPhoneNo(long phoneNo) {this.phoneNo = phoneNo;}
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    public String getVehicleInfo() { return getVehicleInfo();
    }
}
