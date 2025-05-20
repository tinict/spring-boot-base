package com.bvtw.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "resource_queue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceQueue {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String resourceName;

    @Column(nullable = false)
    private String payload;

    @Column(nullable = false)
    private String status;

    @Column(nullable = true)
    private String result;

    @Column(nullable = false)
    private int retryCount;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime startedAt;

    @Column(nullable = true)
    private LocalDateTime finishedAt;

    @Column(nullable = true)
    private String errorMessage;
}
