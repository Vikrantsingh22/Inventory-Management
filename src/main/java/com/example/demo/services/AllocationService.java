package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inventory;
import com.example.demo.repositories.AllocationRepository;

import com.example.demo.entity.Allocation;
import com.example.demo.entity.Inventory;
import com.example.demo.repositories.AllocationRepository;
import com.example.demo.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {
    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    public Optional<Allocation> getAllocationById(Long id) {
        return allocationRepository.findById(id);
    }

    public Allocation addAllocation(Allocation allocation) throws Exception {
        Inventory inventory = inventoryRepository.findById(allocation.getInventory().getId())
                .orElseThrow(() -> new Exception("Inventory not found"));
        
        if (inventory.getQuantity() < allocation.getQuantity()) {
            throw new Exception("Insufficient stock. Available quantity: " + inventory.getQuantity());
        }
        allocation.setEventId(allocation.getEventId());
        allocation.setVenueId(allocation.getVenueId());
        inventory.setQuantity(inventory.getQuantity() - allocation.getQuantity());
        inventoryRepository.save(inventory);

        return allocationRepository.save(allocation);
    }

    public void deleteAllocation(Long id) {
        allocationRepository.deleteById(id);
    }
}
