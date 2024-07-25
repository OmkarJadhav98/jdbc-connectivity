package com.project;

import com.project.model.*;
import com.project.repository.*;
import com.project.service.*;

import java.util.ArrayList;
import java.util.List;

public class App {

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

        // Create sample data

        // Create Address and Contact for Customer
        Address customerAddress = new Address(1, "John Doe", "123 Main St", "Building 5", "India");
        Contact customerContact = new Contact(1, customerAddress, "john.doe@example.com", "555-1234");
        Customer customer = new Customer(1, "johndoe", "password", customerContact);

        // Add customer to the repository
        customerService.addCustomer(customer);

        // Create Address and Contact for Restaurant
        Address restaurantAddress = new Address(2, "Pizza Place", "456 Food St", "Suite 7", "Cityville");
        Contact restaurantContact = new Contact(2, restaurantAddress, "contact@pizzaplace.com", "555-5678");
        Restaurant restaurant = new Restaurant(1, "Pizza Place", restaurantContact, new ArrayList<>());

        // Add restaurant to the repository
        restaurantService.addRestaurant(restaurant);

        // Create Menu items
        Menu menu1 = new Menu(1, "Pepperoni Pizza", "Delicious pepperoni pizza", 12.99, restaurant, "InStock");

        // Add menu to the repository
        menuService.addMenu(menu1);

        // Add menu to restaurant's menu list
        List<Menu> menuItems = new ArrayList<>();
        menuItems.add(menu1);
        restaurant.setMenuItems(menuItems);

        // Create Kart with selected menus
        List<Menu> selectedMenus = new ArrayList<>();
        selectedMenus.add(menu1);
        Kart kart = new Kart(1, selectedMenus, 12.99, customer, restaurant);

        // Add kart to the repository
        kartService.addKart(kart);

        // Create Delivery Executive
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive(1, "Jane Smith", "Bike", true);

        // Add delivery executive to the repository
        deliveryExecutiveService.addDeliveryExecutive(deliveryExecutive);

        // Retrieve and display all customers
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println("Customers:");
        for (Customer cust : customers) {
            System.out.println(cust.getUsername() + " (" + cust.getContact().getEmailId() + ")");
        }

        // Retrieve and display all delivery executives
        List<DeliveryExecutive> deliveryExecutives = deliveryExecutiveService.getAllDeliveryExecutives();
        System.out.println("Delivery Executives:");
        for (DeliveryExecutive de : deliveryExecutives) {
            System.out.println(de.getName() + " (" + de.getVehicleInfo() + ")");
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
