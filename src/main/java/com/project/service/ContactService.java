package com.project.service;

import com.project.model.Contact;
import com.project.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);
    private final ContactRepository contactRepository;

    public ContactService() {
        this.contactRepository = new ContactRepository();
    }

    public void createContact(Contact contact) {
        try {
            contactRepository.createContact(contact);
            logger.info("Contact created successfully with ID: {}", contact.getId());
        } catch (Exception e) {
            logger.error("Error creating contact: {}", e.getMessage(), e);
        }
    }

    public void updateContact(Contact contact) {
        try {
            contactRepository.updateContact(contact);
            logger.info("Contact updated successfully with ID: {}", contact.getId());
        } catch (Exception e) {
            logger.error("Error updating contact: {}", e.getMessage(), e);
        }
    }

    public Contact getContactById(int id) {
        try {
            Contact contact = contactRepository.getContactById(id);
            if (contact != null) {
                logger.info("Contact retrieved successfully with ID: {}", id);
            } else {
                logger.warn("Contact with ID {} not found", id);
            }
            return contact;
        } catch (Exception e) {
            logger.error("Error retrieving contact with ID {}: {}", id, e.getMessage(), e);
            return null;
        }
    }

    public void deleteContact(int id) {
        try {
            contactRepository.deleteContact(id);
            logger.info("Contact deleted successfully with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting contact with ID {}: {}", id, e.getMessage(), e);
        }
    }
}
