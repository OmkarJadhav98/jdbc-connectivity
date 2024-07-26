package com.project.service;

import com.project.model.Address;
import com.project.repository.AddressRepository;

import java.util.List;
import java.util.Scanner;

public class AddressService {
    private final AddressRepository addressRepository;
    private final Scanner scanner;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.scanner = new Scanner(System.in);
    }

    public List<Address> retrieveAddresses() {
        return addressRepository.retrieveAddresses();
    }

    public void createAddress() {
        System.out.println("Enter Address ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter flatNo:");
        long flatNo = scanner.nextLong();

        System.out.println("Enter buildingName:");
        String buildingName = scanner.nextLine();

        System.out.println("Enter street:");
        String street = scanner.nextLine();

        System.out.println("Enter city:");
        String city = scanner.nextLine();

        System.out.println("Enter state:");
        String state = scanner.nextLine();

        System.out.println("Enter Pin Code:");
        long pinCode = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Address address = new Address(id, name, flatNo, buildingName, street, city, state, pinCode);
        addressRepository.createAddress(address);
        System.out.println("Address created successfully.");
    }

    public void updateAddress() {
        System.out.println("Enter Address ID to Update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New name:");
        String name = scanner.nextLine();

        System.out.println("Enter New flatNo:");
        long flatNo = scanner.nextLong();

        System.out.println("Enter New buildingName:");
        String buildingName = scanner.nextLine();

        System.out.println("Enter New street:");
        String street = scanner.nextLine();

        System.out.println("Enter New city:");
        String city = scanner.nextLine();

        System.out.println("Enter New state:");
        String state = scanner.nextLine();

        System.out.println("Enter New Pin Code:");
        long pinCode = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Address address = new Address(id, name, flatNo, buildingName, street, city, state, pinCode);
        addressRepository.updateAddress(address);
        System.out.println("Address updated successfully.");
    }

    public void deleteAddress() {
        System.out.println("Enter Address ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        addressRepository.deleteAddress(id);
        System.out.println("Address deleted successfully.");
    }

    public void findAddressById() {
        System.out.println("Enter Address ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Address address = addressRepository.findById(id);
        if (address != null) {
            System.out.println("Address found: " + address);
        } else {
            System.out.println("Address not found.");
        }
    }
}
