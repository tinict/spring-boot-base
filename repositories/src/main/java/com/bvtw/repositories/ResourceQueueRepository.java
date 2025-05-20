package com.bvtw.repositories;

import com.bvtw.domain.entity.ResourceQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceQueueRepository extends JpaRepository<ResourceQueue, String> {
}
