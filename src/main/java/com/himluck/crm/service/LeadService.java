package com.himluck.crm.service;

import com.himluck.crm.model.Lead;
import com.himluck.crm.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Optional<Lead> getLeadById(UUID id) {
        return leadRepository.findById(id);
    }

    public Lead saveLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public void deleteLead(UUID id) {
        leadRepository.deleteById(id);
    }
}
