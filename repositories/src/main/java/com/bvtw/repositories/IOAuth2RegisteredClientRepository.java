package com.bvtw.repositories;

import com.bvtw.domain.entity.OAuth2RegisteredClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOAuth2RegisteredClientRepository extends JpaRepository<OAuth2RegisteredClient, String> {
    Optional<OAuth2RegisteredClient> findByClientId(String clientId);

    boolean existsByClientId(String clientId);
}
