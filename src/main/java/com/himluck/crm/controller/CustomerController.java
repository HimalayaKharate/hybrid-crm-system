package com.himluck.crm.controller;

import com.himluck.crm.model.Customer;
import com.himluck.crm.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/crm-api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService service){
        this.customerService = service;
    }
    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a customer with an assigned user
    @PostMapping("/{assignedUserId}")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, @PathVariable UUID assignedUserId) {
        return ResponseEntity.ok(customerService.createCustomer(customer, assignedUserId));
    }

    // Update a customer and assign to a different user
    @PutMapping("/{id}/{assignedUserId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer customerDetails, @PathVariable UUID assignedUserId) {
        try {
            return ResponseEntity.ok(customerService.updateCustomer(id, customerDetails, assignedUserId));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
