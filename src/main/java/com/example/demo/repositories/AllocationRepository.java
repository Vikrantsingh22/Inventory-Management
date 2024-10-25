package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Allocation;
@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {}