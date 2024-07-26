package com.project.service;

import com.project.model.Contact;
import com.project.model.Customer;
import com.project.repository.ContactRepository;
import com.project.repository.CustomerRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private ContactRepository contactRepository;
    private final Scanner scanner;

    // Updated constructor to include ContactRepository
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.contactRepository = contactRepository;
        this.scanner = new Scanner(System.in);
    }

    public List<Customer> retrieveCustomers() {
        return customerRepository.retrieveCustomers();
    }

    public void createCustomer() {
        System.out.println("Enter Customer ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Contact ID:");
        long contactId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        // Fetch Contact using contactId
        Contact contact = contactRepository.findById(contactId); // Ensure this method exists in ContactRepository

        Customer customer = new Customer(id, name, email, contact);
        customerRepository.createCustomer(customer);
        System.out.println("Customer created successfully.");
    }

    public void updateCustomer() {
        System.out.println("Enter Customer ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Name:");
        String name = scanner.nextLine();

        System.out.println("Enter New Email:");
        String email = scanner.nextLine();

        System.out.println("Enter New Contact ID:");
        long contactId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        // Fetch Contact using contactId
        Contact contact = contactRepository.findById(contactId);

        Customer customer = new Customer(id, name, email, contact);
        customerRepository.updateCustomer(customer);
        System.out.println("Customer updated successfully.");
    }

    public void deleteCustomer() {
        System.out.println("Enter Customer ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        customerRepository.deleteCustomer(id);
        System.out.println("Customer deleted successfully.");
    }

    public void findCustomerById() {
        System.out.println("Enter Customer ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Customer customer = customerRepository.findById((int) id);
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}
