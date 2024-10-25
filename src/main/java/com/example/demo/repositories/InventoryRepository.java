package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
