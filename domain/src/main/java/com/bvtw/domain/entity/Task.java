package com.bvtw.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(length = 36)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "task_group", nullable = false)
    private String taskGroup;

    @Column(name = "cron_expression")
    private String cronExpression;
}
