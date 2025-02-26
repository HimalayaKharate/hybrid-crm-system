package com.himluck.crm.service;


import com.himluck.crm.model.AddCustomerTicket;
import com.himluck.crm.model.Customer;
import com.himluck.crm.repository.AddCustomerRepository;
import com.himluck.crm.repository.CustomerRepository;
import com.himluck.crm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddCustomerService {
    AddCustomerRepository repository;
    UserRepository repo;
    CustomerRepository customerRepository;

    public AddCustomerService(AddCustomerRepository repo, UserRepository repo1, CustomerRepository repository){
        this.repository = repo;
        this.repo = repo1;
        this.customerRepository = repository;
    }


    public List<AddCustomerTicket> getTickets() {
        return repository.findAll();
    }

    public void addTicket(AddCustomerTicket ticket) {
        repository.save(ticket);
    }

    public void allowTickets(List<UUID> uuids, UUID id) {
        for(UUID uuid : uuids){
            var t =  repository.findById(id).orElse(null);
            if(t == null)  return;
            Customer customer = new Customer();
            customer.setName(t.getName());
            customer.setAddress(t.getAddress());
            customer.setEmail(t.getEmail());
            customer.setCity(t.getCity());
            customer.setCountry(t.getCountry());
            customer.setAssignedTo(repo.findById(id).orElse(null));
            customer.setCompanyName(t.getCompanyName());
            customer.setIndustry(t.getIndustry());
            customer.setPhone(t.getPhone());
            customer.setState(t.getState());
            customer.setZipCode(t.getZipCode());
            customerRepository.save(customer);
            t.setAssigned(true);
            repository.save(t);
        }
    }
}
