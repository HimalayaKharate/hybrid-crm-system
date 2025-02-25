package com.himluck.crm.service;

import com.himluck.crm.model.Customer;
import com.himluck.crm.model.User;
import com.himluck.crm.repository.CustomerRepository;
import com.himluck.crm.repository.UserRepository;
import com.himluck.crm.utils.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {


    private CustomerRepository customerRepository;
    private  UserRepository userRepository;
    private JwtFilter filter;
    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository, JwtFilter filter) {
        this.filter = filter;
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    // Create a new customer and assign a user
    public Customer createCustomer(Customer customer, UUID assignedUserId) {
        User assignedUser = userRepository.findById(assignedUserId)
                .orElseThrow(() -> new RuntimeException("Assigned user not found"));
        customer.setAssignedTo(assignedUser);
        return customerRepository.save(customer);
    }

    // Update an existing customer
    public Customer updateCustomer(UUID id, Customer customerDetails, UUID assignedUserId) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhone(customerDetails.getPhone());
            customer.setCompanyName(customerDetails.getCompanyName());
            customer.setIndustry(customerDetails.getIndustry());
            customer.setAddress(customerDetails.getAddress());
            customer.setCity(customerDetails.getCity());
            customer.setState(customerDetails.getState());
            customer.setCountry(customerDetails.getCountry());
            customer.setZipCode(customerDetails.getZipCode());

            User assignedUser = userRepository.findById(assignedUserId)
                    .orElseThrow(() -> new RuntimeException("Assigned user not found"));
            customer.setAssignedTo(assignedUser);

            return customerRepository.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // Delete a customer
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }



    public List<Customer> getCustomersForSales(){
        User user = userRepository.findByEmail(filter.getLoggedInUserEmail()).orElse(null);
        if(user == null) return null;
        return customerRepository.findByAssignedTo(user);
    }
 }
