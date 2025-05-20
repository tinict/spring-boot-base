package com.bvtw.repositories;

import com.bvtw.domain.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPartnerRepository extends JpaRepository<Partner, String> {
    Optional<Partner> findByPartnerCode(String partnerCode);

    Optional<Partner> findByPartnerName(String partnerName);

    boolean existsByPartnerCode(String partnerCode);

    List<Partner> findByPartnerStatus(String partnerStatus);
}
