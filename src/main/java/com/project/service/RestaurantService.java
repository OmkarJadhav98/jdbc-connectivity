package com.project.service;

import com.project.model.Restaurant;
import com.project.repository.RestaurantRepository;
import java.util.List;

public class RestaurantService {

    private final RestaurantRepository restaurantRepository = new RestaurantRepository();

    public RestaurantService(RestaurantRepository restaurantRepository) {
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.retrieveRestaurants();
    }

    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.findById(id);
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.createRestaurant(restaurant);
    }

    public void updateRestaurant(Restaurant restaurant) {
        restaurantRepository.updateRestaurant(restaurant);
    }

    public void removeRestaurant(long id) {
        restaurantRepository.deleteRestaurant(id);
    }
}
