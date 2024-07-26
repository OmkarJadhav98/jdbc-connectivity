package com.project.service;

import com.project.model.Address;
import com.project.model.Contact;
import com.project.repository.ContactRepository;

import java.util.List;
import java.util.Scanner;

public class ContactService {
    private final ContactRepository contactRepository;
    private final Scanner scanner;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        this.scanner = new Scanner(System.in);
    }

    public List<Contact> retrieveContacts() {
        return contactRepository.retrieveContacts();
    }

    public void createContact() {
        System.out.println("Enter Contact ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Phone Number:");
        long phone = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Flat No:");
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

        Address address = new Address(id, "", flatNo, buildingName, street, city, state, pinCode);
        Contact contact = new Contact(id, phone, address);
        contactRepository.createContact(contact);
        System.out.println("Contact created successfully.");
    }

    public void updateContact() {
        System.out.println("Enter Contact ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Phone Number:");
        long phone = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Flat No:");
        long flatNo = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Building Name:");
        String buildingName = scanner.nextLine();

        System.out.println("Enter New Street:");
        String street = scanner.nextLine();

        System.out.println("Enter New City:");
        String city = scanner.nextLine();

        System.out.println("Enter New State:");
        String state = scanner.nextLine();

        System.out.println("Enter New Pin Code:");
        long pinCode = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Address address = new Address(id, "", flatNo, buildingName, street, city, state, pinCode);
        Contact contact = new Contact(id, phone, address);
        contactRepository.updateContact(contact);
        System.out.println("Contact updated successfully.");
    }


    public void deleteContact() {
        System.out.println("Enter Contact ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        contactRepository.deleteContact((int) id);
        System.out.println("Contact deleted successfully.");
    }

    public void findContactById() {
        System.out.println("Enter Contact ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Contact contact = contactRepository.findById(id);
        if (contact != null) {
            System.out.println("Contact found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }
}
