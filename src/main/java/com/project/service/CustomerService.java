package com.project.service;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;
import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.retrieveCustomers();
    }

    public void addCustomer(Customer customer) {
        customerRepository.createCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    public void removeCustomer(long id) {
        customerRepository.deleteCustomer(id);
    }
}
