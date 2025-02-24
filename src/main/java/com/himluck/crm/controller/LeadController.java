package com.himluck.crm.controller;

import com.himluck.crm.model.Lead;
import com.himluck.crm.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("crm-api/v1/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService service){
        this.leadService = service;
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable UUID id) {
        return leadService.getLeadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lead createLead(@RequestBody Lead lead) {
        return leadService.saveLead(lead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable UUID id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}
