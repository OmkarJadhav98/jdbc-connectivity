package com.project.service;

import com.project.model.DeliveryExecutive;
import com.project.repository.DeliveryExecutiveRepository;

import java.util.List;
import java.util.Scanner;

public class DeliveryExecutiveService {
    private final DeliveryExecutiveRepository deliveryExecutiveRepository;
    private final Scanner scanner;

    public DeliveryExecutiveService(DeliveryExecutiveRepository deliveryExecutiveRepository) {
        this.deliveryExecutiveRepository = deliveryExecutiveRepository;
        this.scanner = new Scanner(System.in);
    }

    public List<DeliveryExecutive> retrieveDeliveryExecutives() {
        return deliveryExecutiveRepository.retrieveDeliveryExecutives();
    }

    public void createDeliveryExecutive() {
        System.out.println("Enter Delivery Executive ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Phone Number:");
        long phoneNo = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Is Available (true/false):");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        DeliveryExecutive deliveryExecutive = new DeliveryExecutive(id, name, phoneNo, isAvailable);
        deliveryExecutiveRepository.createDeliveryExecutive(deliveryExecutive);
        System.out.println("Delivery Executive created successfully.");
    }

    public void updateDeliveryExecutive() {
        System.out.println("Enter Delivery Executive ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Name:");
        String name = scanner.nextLine();

        System.out.println("Enter New Phone Number:");
        long phoneNo = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Is Available (true/false):");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        DeliveryExecutive deliveryExecutive = new DeliveryExecutive(id, name, phoneNo, isAvailable);
        deliveryExecutiveRepository.updateDeliveryExecutive(deliveryExecutive);
        System.out.println("Delivery Executive updated successfully.");
    }

    public void deleteDeliveryExecutive() {
        System.out.println("Enter Delivery Executive ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        deliveryExecutiveRepository.deleteDeliveryExecutive(id);
        System.out.println("Delivery Executive deleted successfully.");
    }

    public void findDeliveryExecutiveById() {
        System.out.println("Enter Delivery Executive ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        DeliveryExecutive deliveryExecutive = deliveryExecutiveRepository.findById(id);
        if (deliveryExecutive != null) {
            System.out.println("Delivery Executive found: " + deliveryExecutive);
        } else {
            System.out.println("Delivery Executive not found.");
        }
    }
}
