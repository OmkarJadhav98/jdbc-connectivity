package com.project.service;

import com.project.model.Contact;
import com.project.model.Menu;
import com.project.model.Restaurant;
import com.project.model.Address;
import com.project.repository.ContactRepository;
import com.project.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private ContactRepository contactRepository; // Added ContactRepository
    private final Scanner scanner;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.contactRepository = contactRepository; // Initialize ContactRepository
        this.scanner = new Scanner(System.in);
    }

    public List<Restaurant> retrieveRestaurants() {
        return restaurantRepository.retrieveRestaurants();
    }

    public void createRestaurant() {
        System.out.println("Enter Restaurant ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        // Collect Contact details
        System.out.println("Enter Contact ID:");
        long contactId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Contact Phone Number:");
        long phone = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        // Collect Address details
        System.out.println("Enter Address Name:");
        String addressName = scanner.nextLine();

        System.out.println("Enter Flat Number:");
        long flatNo = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Building Name:");
        String buildingName = scanner.nextLine();

        System.out.println("Enter Street:");
        String street = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Pin Code:");
        long pinCode = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Address address = new Address(0, addressName, flatNo, buildingName, street, city, state, pinCode); // ID set to 0 for new Address
        Contact contact = new Contact(contactId, phone, address);
        contactRepository.createContact(contact); // Save contact

        List<Menu> menus = new ArrayList<>(); // Initialize empty list of menus

        Restaurant restaurant = new Restaurant(id, name, contact, menus);
        restaurantRepository.createRestaurant(restaurant);
        System.out.println("Restaurant created successfully.");
    }

    public void updateRestaurant() {
        System.out.println("Enter Restaurant ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Name:");
        String name = scanner.nextLine();

        // Collect Contact details
        System.out.println("Enter Contact ID:");
        long contactId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Contact Phone Number:");
        long phone = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        // Collect Address details
        System.out.println("Enter Address Name:");
        String addressName = scanner.nextLine();

        System.out.println("Enter Flat Number:");
        long flatNo = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Building Name:");
        String buildingName = scanner.nextLine();

        System.out.println("Enter Street:");
        String street = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Pin Code:");
        long pinCode = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Address address = new Address(0, addressName, flatNo, buildingName, street, city, state, pinCode); // ID set to 0 for updated Address
        Contact contact = new Contact(contactId, phone, address);
        contactRepository.updateContact(contact); // Update contact

        List<Menu> menus = new ArrayList<>(); // Initialize empty list of menus

        Restaurant restaurant = new Restaurant(id, name, contact, menus);
        restaurantRepository.updateRestaurant(restaurant);
        System.out.println("Restaurant updated successfully.");
    }

    public void deleteRestaurant() {
        System.out.println("Enter Restaurant ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        restaurantRepository.deleteRestaurant(id);
        System.out.println("Restaurant deleted successfully.");
    }

    public void findRestaurantById() {
        System.out.println("Enter Restaurant ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Restaurant restaurant = restaurantRepository.findById(id);
        if (restaurant != null) {
            System.out.println("Restaurant found: " + restaurant);
        } else {
            System.out.println("Restaurant not found.");
        }
    }
}
