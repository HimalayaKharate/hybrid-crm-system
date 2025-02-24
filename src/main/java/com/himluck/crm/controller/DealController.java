package com.himluck.crm.controller;
import com.himluck.crm.model.Deal;
import com.himluck.crm.service.DealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("crm-api/v1/deals")
public class DealController {
    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping
    public List<Deal> getAllDeals() {
        return dealService.getAllDeals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deal> getDealById(@PathVariable UUID id) {
        return dealService.getDealById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Deal createDeal(@RequestBody Deal deal) {
        return dealService.saveDeal(deal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeal(@PathVariable UUID id) {
        dealService.deleteDeal(id);
        return ResponseEntity.noContent().build();
    }
}
