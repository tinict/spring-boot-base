package com.bvtw.service.identifier;

import com.bvtw.domain.entity.Partner;
import com.bvtw.repositories.IPartnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PartnerService implements IPartnerService {
    private final IPartnerRepository partnerRepository;

    @Override
    public List<Partner> findAll() {
        return List.of();
    }

    @Override
    public Optional<Partner> findById(String id) {
        return partnerRepository.findById(id);
    }

    @Override
    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public void delete(Partner partner) {

    }

    @Override
    public void deleteById(String id) {

    }
}
