package com.himluck.crm.service;


import com.himluck.crm.repository.AddCustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class AddCustomerService {
    AddCustomerRepository repository;

    public AddCustomerService(AddCustomerRepository repo){
        this.repository = repo;
    }



}
