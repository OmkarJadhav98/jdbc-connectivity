package com.project.service;

import com.project.model.Order;
import com.project.repository.OrderRepository;
import java.util.List;

public class OrderService {

    private final OrderRepository orderRepository = new OrderRepository();

    public List<Order> getAllOrders() {
        return orderRepository.retrieveOrders();
    }

    public Order getOrderById(long id) {
        return orderRepository.findById(id);
    }

    public void addOrder(Order order) {
        orderRepository.createOrder(order);
    }

    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    public void removeOrder(long id) {
        orderRepository.deleteOrder(id);
    }
}
