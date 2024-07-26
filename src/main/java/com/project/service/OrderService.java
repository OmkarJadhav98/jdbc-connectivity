package com.project.service;

import com.project.model.Order;
import com.project.model.Customer;
import com.project.model.Menu;
import com.project.model.DeliveryExecutive;
import com.project.repository.OrderRepository;
import com.project.repository.CustomerRepository;
import com.project.repository.MenuRepository;
import com.project.repository.DeliveryExecutiveRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private final OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private MenuRepository menuRepository;
    private DeliveryExecutiveRepository deliveryExecutiveRepository;
    private final Scanner scanner;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.menuRepository = menuRepository;
        this.deliveryExecutiveRepository = deliveryExecutiveRepository;
        this.scanner = new Scanner(System.in);
    }

    public List<Order> retrieveOrders() {
        return orderRepository.retrieveOrders();
    }

    public void createOrder() {
        System.out.println("Enter Order ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Customer ID:");
        long customerId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Menu ID:");
        long menuId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Delivery Executive ID:");
        long deliveryExecutiveId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        // Fetch the actual objects
        Customer customer = customerRepository.findById(customerId);
        Menu menu = menuRepository.findById(menuId);
        DeliveryExecutive deliveryExecutive = deliveryExecutiveRepository.findById(deliveryExecutiveId);
        LocalDateTime timestamp = LocalDateTime.now(); // Assuming you want to set the current timestamp

        Order order = new Order(id, customer, menu, deliveryExecutive, timestamp);
        orderRepository.createOrder(order);
        System.out.println("Order created successfully.");
    }

    public void updateOrder() {
        System.out.println("Enter Order ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Customer ID:");
        long customerId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Menu ID:");
        long menuId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Delivery Executive ID:");
        long deliveryExecutiveId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        // Fetch the actual objects
        Customer customer = customerRepository.findById(customerId);
        Menu menu = menuRepository.findById(menuId);
        DeliveryExecutive deliveryExecutive = deliveryExecutiveRepository.findById(deliveryExecutiveId);
        LocalDateTime timestamp = LocalDateTime.now(); // Assuming you want to set the current timestamp

        Order order = new Order(id, customer, menu, deliveryExecutive, timestamp);
        orderRepository.updateOrder(order);
        System.out.println("Order updated successfully.");
    }

    public void deleteOrder() {
        System.out.println("Enter Order ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        orderRepository.deleteOrder(id);
        System.out.println("Order deleted successfully.");
    }

    public void findOrderById() {
        System.out.println("Enter Order ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Order order = orderRepository.findById(id);
        if (order != null) {
            System.out.println("Order found: " + order);
        } else {
            System.out.println("Order not found.");
        }
    }
}
