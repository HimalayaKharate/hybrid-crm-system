package com.himluck.crm.controller;

import com.himluck.crm.model.SupportTicket;
import com.himluck.crm.service.SupportTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("crm-api/v1/support-tickets")
public class SupportTicketController {
    private final SupportTicketService supportTicketService;

    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    @GetMapping
    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketService.getAllSupportTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getSupportTicketById(@PathVariable UUID id) {
        return supportTicketService.getSupportTicketById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SupportTicket createSupportTicket(@RequestBody SupportTicket supportTicket) {
        return supportTicketService.saveSupportTicket(supportTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupportTicket(@PathVariable UUID id) {
        supportTicketService.deleteSupportTicket(id);
        return ResponseEntity.noContent().build();
    }
}
