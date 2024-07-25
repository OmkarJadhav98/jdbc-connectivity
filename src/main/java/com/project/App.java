package com.project;

import com.project.model.Customer;
import com.project.model.DeliveryExecutive;
import com.project.model.Kart;
import com.project.model.Menu;
import com.project.model.Restaurant;
import com.project.repository.CustomerRepository;
import com.project.repository.DeliveryExecutiveRepository;
import com.project.repository.KartRepository;
import com.project.repository.MenuRepository;
import com.project.repository.RestaurantRepository;
import com.project.service.CustomerService;
import com.project.service.DeliveryExecutiveService;
import com.project.service.KartService;
import com.project.service.MenuService;
import com.project.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        // Initialize Repositories
        CustomerRepository customerRepository = new CustomerRepository();
        DeliveryExecutiveRepository deliveryExecutiveRepository = new DeliveryExecutiveRepository();
        KartRepository kartRepository = new KartRepository();
        MenuRepository menuRepository = new MenuRepository();
        RestaurantRepository restaurantRepository = new RestaurantRepository();

        // Initialize Services
        CustomerService customerService = new CustomerService(customerRepository);
        DeliveryExecutiveService deliveryExecutiveService = new DeliveryExecutiveService(deliveryExecutiveRepository);
        KartService kartService = new KartService(kartRepository);
        MenuService menuService = new MenuService(menuRepository);
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);

        // Example Usage

        // Create a new Customer
        Customer customer = new Customer(0, "John Doe", "john.doe@example.com", null); // Replace with actual Contact object
        customerService.addCustomer(customer);

        // Create a new Delivery Executive
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive(0, "Jane Smith", "555-1234", true);
        deliveryExecutiveService.addDeliveryExecutive(deliveryExecutive);

        // Create a new Restaurant
        Restaurant restaurant = new Restaurant(0, "Pizza Place", "123 Pizza Lane", "555-5678");
        restaurantService.addRestaurant(restaurant);

        // Create a new Menu
        Menu menu = new Menu(0, "Pepperoni Pizza", "Delicious pepperoni pizza", 12.99, restaurant, "Pizza", true);
        menuService.addMenu(menu);

        // Create a new Kart
        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        Kart kart = new Kart(0, menus, 12.99, customer, restaurant);
        kartService.addKart(kart);

        // Retrieve and display all customers
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println("Customers:");
        for (Customer cust : customers) {
            System.out.println(cust.getName() + " (" + cust.getEmail() + ")");
        }

        // Retrieve and display all delivery executives
        List<DeliveryExecutive> deliveryExecutives = deliveryExecutiveService.getAllDeliveryExecutives();
        System.out.println("Delivery Executives:");
        for (DeliveryExecutive de : deliveryExecutives) {
            System.out.println(de.getName() + " (" + de.getPhoneNumber() + ")");
        }

        // Retrieve and display all karts
        List<Kart> karts = kartService.getAllKarts();
        System.out.println("Karts:");
        for (Kart kartItem : karts) {
            System.out.println("Kart ID: " + kartItem.getId() + ", Final Price: " + kartItem.getFinalPrice());
        }

        // Cleanup (Optional)
        // Remove a customer, delivery executive, or kart as needed
    }
}
