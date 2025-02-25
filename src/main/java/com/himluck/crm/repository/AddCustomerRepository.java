package com.himluck.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.himluck.crm.model.AddCustomerTicket;

import java.util.UUID;

@Repository
public interface AddCustomerRepository extends JpaRepository<AddCustomerTicket, UUID> {



}
