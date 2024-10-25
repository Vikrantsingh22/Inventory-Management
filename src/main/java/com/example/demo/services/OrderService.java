package com.example.demo.services;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Order;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order addOrder(Order order) {
        // Check if only inventory ID is provided and fetch full Inventory entity
        if (order.getInventory() != null && order.getInventory().getId() != null) {
            Inventory inventory = inventoryRepository.findById(order.getInventory().getId())
                    .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + order.getInventory().getId()));
            order.setInventory(inventory); // Set the fetched Inventory object
        }
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
