package com.laptrinhweb.run.converter;

import com.laptrinhweb.run.dto.CategoryDTO;
import com.laptrinhweb.run.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTO toDto(CategoryEntity entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        return dto;
    }
    public CategoryEntity toDto(CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }
}
