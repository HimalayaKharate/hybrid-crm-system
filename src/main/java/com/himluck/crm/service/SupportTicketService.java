package com.himluck.crm.service;

import com.himluck.crm.model.SupportTicket;
import com.himluck.crm.repository.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupportTicketService {

    private final SupportTicketRepository supportTicketRepository;

    public SupportTicketService(SupportTicketRepository supportTicketRepository) {
        this.supportTicketRepository = supportTicketRepository;
    }

    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketRepository.findAll();
    }

    public Optional<SupportTicket> getSupportTicketById(UUID id) {
        return supportTicketRepository.findById(id);
    }

    public SupportTicket saveSupportTicket(SupportTicket supportTicket) {
        return supportTicketRepository.save(supportTicket);
    }

    public void deleteSupportTicket(UUID id) {
        supportTicketRepository.deleteById(id);
    }
}
