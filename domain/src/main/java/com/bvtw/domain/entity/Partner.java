package com.bvtw.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "partners")
public class Partner extends BaseEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(length = 36)
    private String id;

    @Column(
            nullable = false,
            unique = true,
            length = 100,
            columnDefinition = "VARCHAR(100)",
            name = "partner_code"
    )
    private String partnerCode;

    @Column(
            nullable = false,
            length = 200,
            name = "partner_name"
    )
    private String partnerName;

    @Column(
            length = 200,
            name = "partner_display_brand_name"
    )
    private String partnerDisplayBrandName;

    @Column(
            length = 100,
            name = "partner_type"
    )
    private String partnerType;

    @Column(
            length = 50,
            name = "partner_status"
    )
    private String partnerStatus;

    @Column(
            length = 500,
            name = "partner_description"
    )
    private String partnerDescription;

    @Column(
            length = 100,
            name = "contact_name"
    )
    private String contactName;

    @Column(
            length = 100,
            name = "contact_email"
    )
    private String contactEmail;

    @Column(
            length = 20,
            name = "contact_phone"
    )
    private String contactPhone;

//    @OneToMany(
//            mappedBy = "partner",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<OAuth2RegisteredClient> clients;
}
