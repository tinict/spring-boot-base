package com.bvtw.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "oauth2_authorizations")
public class OAuth2Authorization {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(
            name = "registration_client_id",
            nullable = false,
            length = 100,
            columnDefinition = "VARCHAR"
    )
    private String registrationClientId;

    @Column(
            name = "principal_name",
            nullable = false,
            length = 100,
            columnDefinition = "VARCHAR"
    )
    private String principalName;

    @Column(
            name = "authorization_grant_type",
            nullable = false,
            length = 100,
            columnDefinition = "VARCHAR"
    )
    private String authorizationGrantType;

    @Column(
            name = "authorized_scopes",
            nullable = true,
            length = 1000,
            columnDefinition = "VARCHAR"
    )
    private String authorizedScopes;

    @Column(
            name = "attributes",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String attributes;

    @Column(
            name = "state",
            nullable = true,
            length = 500,
            columnDefinition = "VARCHAR"
    )
    private String state;

    @Column(
            name = "authorization_code_value",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String authorizationCodeValue;

    @Column(
            name = "authorization_code_issued_at",
            nullable = true
    )
    private LocalDateTime authorizationCodeIssuedAt;

    @Column(
            name = "authorization_code_expires_at",
            nullable = true
    )
    private LocalDateTime authorizationCodeExpiresAt;

    @Column(
            name = "authorization_code_metadata",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String authorizationCodeMetadata;

    @Column(
            name = "access_token_value",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String access_token_value;

    @Column(
            name = "access_token_issued_at",
            nullable = true
    )
    private LocalDateTime accessTokenIssuedAt;

    @Column(
            name = "access_token_expires_at",
            nullable = true
    )
    private LocalDateTime accessTokenExpiresAt;

    @Column(
            name = "access_token_metadata",
            nullable = true
    )
    private String accessTokenMetadata;

    @Column(
            name = "access_token_type",
            nullable = true
    )
    private String accessTokenType;

    @Column(
            name = "access_token_scopes",
            length = 1000,
            nullable = true,
            columnDefinition = "VARCHAR"
    )
    private String accessTokenScopes;

    @Column(
            name = "oidc_id_token_value",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String oidcIdTokenValue;

    @Column(
            name = "oidc_id_token_issued_at",
            nullable = true
    )
    private LocalDateTime oidcIdTokenIssuedAt;

    @Column(
            name = "oidc_id_token_expires_at",
            nullable = true
    )
    private LocalDateTime oidcIdTokenExpiresAt;

    @Column(
            name = "oidc_id_token_metadata",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String oidcIdTokenMetadata;

    @Column(
            name = "refresh_token_issued_at",
            nullable = true
    )
    private LocalDateTime refreshTokenIssuedAt;

    @Column(
            name = "refresh_token_metadata",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String refreshTokenMetadata;

    @Column(
            name = "user_code_value",
            nullable = true,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String userCodeValue;

    @Column(
            name = "user_code_issued_at",
            nullable = true
    )
    private LocalDateTime userCodeIssuedAt;

    @Column(
            name = "user_code_expires_at",
            nullable = true
    )
    private LocalDateTime userCodeExpiresAt;

    @Column(
            name = "user_code_metadata"

    )
    private String userCodeMetadata;

    @Column(
            name = "device_code_value",
            nullable = false,
            columnDefinition = "VARCHAR(MAX)"
    )
    private String deviceCodeValue;

    @Column(
            name = "device_code_issued_at",
            nullable = true
    )
    private LocalDateTime deviceCodeIssuedAt;

    @Column(
            name = "device_code_expires_at",
            nullable = true
    )
    private LocalDateTime deviceCodeExpiresAt;

    @Column(
            name = "device_code_metadata",
            nullable = true
    )
    private LocalDateTime deviceCodeMetadata;
}
