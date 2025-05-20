package com.bvtw.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "oauth2_client_roles")
public class OAuth2ClientRole {
    @Id
    private Long id;

    private String clientRegistrationId;
    private String roleCode;

    @ManyToOne
    @JoinTable(
            name = "oauth2_client_role_mapping",
            joinColumns = {
                    @JoinColumn(name = "oauth_client_role_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Role role;
}