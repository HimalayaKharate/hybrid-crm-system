package com.himluck.crm.controller;

import org.springframework.web.bind.annotation.RestController;
import com.himluck.crm.service.AddCustomerService;
@RestController
public class AddCustomerController {
    private AddCustomerService service;

    public AddCustomerController(AddCustomerService service){
        this.service = service;
    }
}
