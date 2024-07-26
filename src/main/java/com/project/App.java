package com.project;

import com.project.repository.*;
import com.project.service.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddressService addressService = new AddressService(new AddressRepository());
        ContactService contactService = new ContactService(new ContactRepository());
        CustomerService customerService = new CustomerService(new CustomerRepository());
        DeliveryExecutiveService deliveryExecutiveService = new DeliveryExecutiveService(new DeliveryExecutiveRepository());
        KartService kartService = new KartService(new KartRepository());
        MenuService menuService = new MenuService(new MenuRepository());
        OrderService orderService = new OrderService(new OrderRepository());
        RestaurantService restaurantService = new RestaurantService(new RestaurantRepository());

        while (true) {
            System.out.println("===================================================");
            System.out.println("-----------Online Food Ordering System-----------");
            System.out.println("===================================================");
            System.out.println("Select an operation:");
            System.out.println("1. Address Operations");
            System.out.println("2. Contact Operations");
            System.out.println("3. Customer Operations");
            System.out.println("4. Delivery Executive Operations");
            System.out.println("5. Kart Operations");
            System.out.println("6. Menu Operations");
            System.out.println("7. Order Operations");
            System.out.println("8. Restaurant Operations");
            System.out.println("9. Exit");

            System.out.print("Enter your choice here: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    handleAddressOperations(addressService, scanner);
                    break;
                case 2:
                    handleContactOperations(contactService, scanner);
                    break;
                case 3:
                    handleCustomerOperations(customerService, scanner);
                    break;
                case 4:
                    handleDeliveryExecutiveOperations(deliveryExecutiveService, scanner);
                    break;
                case 5:
                    handleKartOperations(kartService, scanner);
                    break;
                case 6:
                    handleMenuOperations(menuService, scanner);
                    break;
                case 7:
                    handleOrderOperations(orderService, scanner);
                    break;
                case 8:
                    handleRestaurantOperations(restaurantService, scanner);
                    break;
                case 9:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void handleAddressOperations(AddressService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Address Operations:");
            System.out.println("1. Retrieve Addresses");
            System.out.println("2. Create Address");
            System.out.println("3. Update Address");
            System.out.println("4. Delete Address");
            System.out.println("5. Find Address by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveAddresses().forEach(System.out::println);
                    break;
                case 2:
                    service.createAddress();
                    break;
                case 3:
                    service.updateAddress();
                    break;
                case 4:
                    service.deleteAddress();
                    break;
                case 5:
                    service.findAddressById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void handleContactOperations(ContactService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Contact Operations:");
            System.out.println("1. Retrieve Contacts");
            System.out.println("2. Create Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Find Contact by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveContacts().forEach(System.out::println);
                    break;
                case 2:
                    service.createContact();
                    break;
                case 3:
                    service.updateContact();
                    break;
                case 4:
                    service.deleteContact();
                    break;
                case 5:
                    service.findContactById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void handleCustomerOperations(CustomerService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Customer Operations:");
            System.out.println("1. Retrieve Customers");
            System.out.println("2. Create Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Find Customer by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveCustomers().forEach(System.out::println);
                    break;
                case 2:
                    service.createCustomer();
                    break;
                case 3:
                    service.updateCustomer();
                    break;
                case 4:
                    service.deleteCustomer();
                    break;
                case 5:
                    service.findCustomerById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void handleDeliveryExecutiveOperations(DeliveryExecutiveService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Delivery Executive Operations:");
            System.out.println("1. Retrieve Delivery Executives");
            System.out.println("2. Create Delivery Executive");
            System.out.println("3. Update Delivery Executive");
            System.out.println("4. Delete Delivery Executive");
            System.out.println("5. Find Delivery Executive by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveDeliveryExecutives().forEach(System.out::println);
                    break;
                case 2:
                    service.createDeliveryExecutive();
                    break;
                case 3:
                    service.updateDeliveryExecutive();
                    break;
                case 4:
                    service.deleteDeliveryExecutive();
                    break;
                case 5:
                    service.findDeliveryExecutiveById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void handleKartOperations(KartService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Kart Operations:");
            System.out.println("1. Retrieve Karts");
            System.out.println("2. Create Kart");
            System.out.println("3. Update Kart");
            System.out.println("4. Delete Kart");
            System.out.println("5. Find Kart by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveKarts().forEach(System.out::println);
                    break;
                case 2:
                    service.createKart();
                    break;
                case 3:
                    service.updateKart();
                    break;
                case 4:
                    service.deleteKart();
                    break;
                case 5:
                    service.findKartById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void handleMenuOperations(MenuService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Operations:");
            System.out.println("1. Retrieve Menus");
            System.out.println("2. Create Menu");
            System.out.println("3. Update Menu");
            System.out.println("4. Delete Menu");
            System.out.println("5. Find Menu by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveMenus().forEach(System.out::println);
                    break;
                case 2:
                    service.createMenu();
                    break;
                case 3:
                    service.updateMenu();
                    break;
                case 4:
                    service.deleteMenu();
                    break;
                case 5:
                    service.findMenuById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void handleOrderOperations(OrderService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Order Operations:");
            System.out.println("1. Retrieve Orders");
            System.out.println("2. Create Order");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Find Order by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveOrders().forEach(System.out::println);
                    break;
                case 2:
                    service.createOrder();
                    break;
                case 3:
                    service.updateOrder();
                    break;
                case 4:
                    service.deleteOrder();
                    break;
                case 5:
                    service.findOrderById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void handleRestaurantOperations(RestaurantService service, Scanner scanner) {
        int choice;
        do {
            System.out.println("Restaurant Operations:");
            System.out.println("1. Retrieve Restaurants");
            System.out.println("2. Create Restaurant");
            System.out.println("3. Update Restaurant");
            System.out.println("4. Delete Restaurant");
            System.out.println("5. Find Restaurant by ID");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice here: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    service.retrieveRestaurants().forEach(System.out::println);
                    break;
                case 2:
                    service.createRestaurant();
                    break;
                case 3:
                    service.updateRestaurant();
                    break;
                case 4:
                    service.deleteRestaurant();
                    break;
                case 5:
                    service.findRestaurantById();
                    break;
                case 6:
                    // Exit the do-while loop
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}
