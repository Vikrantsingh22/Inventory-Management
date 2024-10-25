package com.example.demo.controllers;

import com.example.demo.entity.Allocation;
import com.example.demo.services.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allocation")
public class AllocationController {
    @Autowired
    private AllocationService allocationService;

    @GetMapping
    public List<Allocation> getAllAllocations() {
        return allocationService.getAllAllocations();
    }

    @GetMapping("/{id}")
    public Allocation getAllocationById(@PathVariable Long id) {
        return allocationService.getAllocationById(id).orElse(null);
    }

    @PostMapping
    public Allocation addAllocation(@RequestBody Allocation allocation) throws Exception {
        return allocationService.addAllocation(allocation);
    }

    @DeleteMapping("/{id}")
    public void deleteAllocation(@PathVariable Long id) {
        allocationService.deleteAllocation(id);
    }
}
