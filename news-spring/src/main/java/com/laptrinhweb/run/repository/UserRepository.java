package com.laptrinhweb.run.repository;

import com.laptrinhweb.run.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

UserEntity findOneByUsernameAndStatus(String username,int status);

}
