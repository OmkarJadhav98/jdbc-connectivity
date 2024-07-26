package com.project.service;

import com.project.model.Kart;
import com.project.model.Customer;
import com.project.model.Restaurant;
import com.project.repository.KartRepository;
import com.project.repository.CustomerRepository;
import com.project.repository.RestaurantRepository;

import java.util.List;
import java.util.Scanner;

public class KartService {
    private final KartRepository kartRepository;
    private CustomerRepository customerRepository;
    private RestaurantRepository restaurantRepository;
    private final Scanner scanner;

    public KartService(KartRepository kartRepository) {
        this.kartRepository = kartRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.scanner = new Scanner(System.in);
    }

    public List<Kart> retrieveKarts() {
        return kartRepository.retrieveKarts();
    }

    public void createKart() {
        System.out.println("Enter Kart ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Final Price:");
        double finalPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Customer ID:");
        long customerId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Restaurant ID:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Customer customer = customerRepository.findById(customerId);
        Restaurant restaurant = restaurantRepository.findById(restaurantId);

        if (customer != null && restaurant != null) {
            Kart kart = new Kart(id, finalPrice, customer, restaurant);
            kartRepository.createKart(kart);
            System.out.println("Kart created successfully.");
        } else {
            System.out.println("Invalid Customer ID or Restaurant ID.");
        }
    }

    public void updateKart() {
        System.out.println("Enter Kart ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Final Price:");
        double finalPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Customer ID:");
        long customerId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Restaurant ID:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Customer customer = customerRepository.findById(customerId);
        Restaurant restaurant = restaurantRepository.findById(restaurantId);

        if (customer != null && restaurant != null) {
            Kart kart = new Kart(id, finalPrice, customer, restaurant);
            kartRepository.updateKart(kart);
            System.out.println("Kart updated successfully.");
        } else {
            System.out.println("Invalid Customer ID or Restaurant ID.");
        }
    }

    public void deleteKart() {
        System.out.println("Enter Kart ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        kartRepository.deleteKart(id);
        System.out.println("Kart deleted successfully.");
    }

    public void findKartById() {
        System.out.println("Enter Kart ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Kart kart = kartRepository.findById(id);
        if (kart != null) {
            System.out.println("Kart found: " + kart);
        } else {
            System.out.println("Kart not found.");
        }
    }
}
