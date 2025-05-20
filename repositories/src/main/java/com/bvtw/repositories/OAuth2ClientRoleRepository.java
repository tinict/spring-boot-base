package com.bvtw.repositories;

import com.bvtw.domain.entity.OAuth2ClientRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuth2ClientRoleRepository extends JpaRepository<OAuth2ClientRole, Long> {
    OAuth2ClientRole findByClientRegistrationIdAndRoleCode(String clientRegistrationId, String roleCode);
}
