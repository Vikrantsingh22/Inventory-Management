package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}