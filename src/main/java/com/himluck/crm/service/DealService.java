package com.himluck.crm.service;

import com.himluck.crm.model.Deal;
import com.himluck.crm.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DealService {

    private final DealRepository dealRepository;

    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    public Optional<Deal> getDealById(UUID id) {
        return dealRepository.findById(id);
    }

    public Deal saveDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    public void deleteDeal(UUID id) {
        dealRepository.deleteById(id);
    }
}
