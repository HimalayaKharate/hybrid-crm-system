package com.himluck.crm.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityLog {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String action;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    private UUID entityId;

    @Column(nullable = false, updatable = false)
    private Instant timestamp;

    @PrePersist
    public void prePersist() {
        timestamp = Instant.now();
    }
}

enum EntityType {
    CUSTOMER, LEAD, DEAL, INVOICE, TASK, SUPPORT_TICKET
}
