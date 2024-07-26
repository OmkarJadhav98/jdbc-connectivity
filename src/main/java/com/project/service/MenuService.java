package com.project.service;

import com.project.model.Menu;
import com.project.model.Restaurant;
import com.project.repository.MenuRepository;
import com.project.repository.RestaurantRepository;

import java.util.List;
import java.util.Scanner;

public class MenuService {
    private final MenuRepository menuRepository;
    private RestaurantRepository restaurantRepository;
    private final Scanner scanner;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.scanner = new Scanner(System.in);
    }

    public List<Menu> retrieveMenus() {
        return menuRepository.retrieveMenus();
    }

    public void createMenu() {
        System.out.println("Enter Menu ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Menu Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Menu Description:");
        String description = scanner.nextLine();

        System.out.println("Enter Menu Price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Restaurant ID:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Menu Availability (true/false):");
        boolean availability = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Restaurant restaurant = restaurantRepository.findById(restaurantId);

        if (restaurant != null) {
            Menu menu = new Menu(id, name, description, price, restaurant, availability);
            menuRepository.createMenu(menu);
            System.out.println("Menu created successfully.");
        } else {
            System.out.println("Invalid Restaurant ID.");
        }
    }

    public void updateMenu() {
        System.out.println("Enter Menu ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Menu Name:");
        String name = scanner.nextLine();

        System.out.println("Enter New Menu Description:");
        String description = scanner.nextLine();

        System.out.println("Enter New Menu Price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Restaurant ID:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter New Menu Availability (true/false):");
        boolean availability = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Restaurant restaurant = restaurantRepository.findById(restaurantId);

        if (restaurant != null) {
            Menu menu = new Menu(id, name, description, price, restaurant, availability);
            menuRepository.updateMenu(menu);
            System.out.println("Menu updated successfully.");
        } else {
            System.out.println("Invalid Restaurant ID.");
        }
    }

    public void deleteMenu() {
        System.out.println("Enter Menu ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        menuRepository.deleteMenu(id);
        System.out.println("Menu deleted successfully.");
    }

    public void findMenuById() {
        System.out.println("Enter Menu ID to find:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Menu menu = menuRepository.findById(id);
        if (menu != null) {
            System.out.println("Menu found: " + menu);
        } else {
            System.out.println("Menu not found.");
        }
    }
}
