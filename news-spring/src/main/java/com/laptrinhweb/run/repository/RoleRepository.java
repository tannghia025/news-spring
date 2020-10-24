package com.laptrinhweb.run.repository;

import com.laptrinhweb.run.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findFirstByCode(String code);
}
