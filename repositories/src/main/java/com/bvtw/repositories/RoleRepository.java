package com.bvtw.repositories;

import com.bvtw.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleCode(String roleCode);
}