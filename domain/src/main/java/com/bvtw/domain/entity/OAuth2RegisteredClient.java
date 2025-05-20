package com.bvtw.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "oauth2_registered_client")
public class OAuth2RegisteredClient extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(length = 36)
    private String id;

    @UuidGenerator
    @Column(
            name = "client_id",
            length = 100,
            columnDefinition = "VARCHAR(100)",
            nullable = false
    )
    private String clientId;

    @Column(
            name = "client_id_issued_at",
            nullable = true

    )
    private LocalDateTime clientIdIssuedAt;

    @Column(
            name = "client_secret",
            length = 200,
            columnDefinition = "VARCHAR(200)",
            nullable = true
    )
    private String clientSecret;

    @Column(
            name = "client_secret_expires_at",
            nullable = true
    )
    private LocalDateTime clientSecretExpiresAt;

    @Column(
            name = "client_name",
            nullable = false,
            length = 200,
            columnDefinition = "VARCHAR(200)"
    )
    private String clientName;

    @Column(
            name = "client_authentication_methods",
            nullable = false,
            length = 1000,
            columnDefinition = "VARCHAR(1000)"
    )
    private String clientAuthenticationMethods;

    @Column(
            name = "authorization_grant_types",
            nullable = false,
            length = 1000,
            columnDefinition = "VARCHAR(1000)"
    )
    private String authorizationGrantTypes;

    @Column(
            name = "redirect_uris",
            nullable = true,
            length = 1000,
            columnDefinition = "VARCHAR(1000)"
    )
    private String redirectUris;

    @Column(
            name = "post_logout_redirect_uris",
            nullable = true,
            length = 1000,
            columnDefinition = "VARCHAR(1000)"
    )
    private String postLogoutRedirectUris;

    @Column(
            name = "scopes",
            nullable = false,
            length = 1000,
            columnDefinition = "VARCHAR(1000)"
    )
    private String scopes;

    @Column(
            name = "client_settings",
            nullable = false,
            length = 2000,
            columnDefinition = "VARCHAR(2000)"
    )
    private String clientSettings;

    @Column(
            name = "token_settings",
            nullable = false,
            length = 2000,
            columnDefinition = "VARCHAR(2000)"
    )
    private String tokenSettings;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "partner_id", nullable = false)
//    @JsonIgnore
//    private Partner partner;
}
