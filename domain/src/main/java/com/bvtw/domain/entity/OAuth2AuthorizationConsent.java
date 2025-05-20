package com.bvtw.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "oauth2_authorization_consents")
public class OAuth2AuthorizationConsent {
    @Id
    @Column(
            name = "registered_client_id",
            nullable = false,
            length = 100,
            columnDefinition = "VARCHAR(100)"
    )
    private String registeredClientId;

    @Column(
            name = "principal_name",
            nullable = false,
            length = 200,
            columnDefinition = "VARCHAR(200)"
    )
    private String principalName;

    @Column(
            name = "authorities",
            nullable = false,
            length = 1000,
            columnDefinition = "VARCHAR(1000)"
    )
    private String authorities;
}
