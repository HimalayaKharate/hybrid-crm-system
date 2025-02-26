package com.himluck.crm.controller;

import com.himluck.crm.model.AddCustomerTicket;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.himluck.crm.service.AddCustomerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/crm-api/v1")
public class AddCustomerController {
    private AddCustomerService service;

    public AddCustomerController(AddCustomerService service){
        this.service = service;
    }

    @GetMapping({"/admin/customer-add", "/sales/customer-add"})
    public ResponseEntity<List<AddCustomerTicket>> getAllTickets(){
        List<AddCustomerTicket> list = service.getTickets();
        if(list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @PostMapping( "/sales/customer-add")
    public ResponseEntity<AddCustomerTicket> postTicket(@RequestBody AddCustomerTicket ticket){
        service.addTicket(ticket);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/admin/customer-add/allow/{a}")
    public void allowThem(@PathVariable UUID id, @RequestBody List<UUID> uuids){
        service.allowTickets(uuids, id);
    }
}
