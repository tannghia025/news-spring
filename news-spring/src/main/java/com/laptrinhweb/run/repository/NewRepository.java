package com.laptrinhweb.run.repository;

import com.laptrinhweb.run.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepository extends JpaRepository<NewEntity,Long> {



}
