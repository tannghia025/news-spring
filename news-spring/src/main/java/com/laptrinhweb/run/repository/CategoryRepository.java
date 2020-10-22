package com.laptrinhweb.run.repository;

import com.laptrinhweb.run.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    CategoryEntity findOneByCode(String code);
}
