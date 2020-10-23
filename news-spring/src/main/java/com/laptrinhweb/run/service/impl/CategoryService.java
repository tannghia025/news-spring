package com.laptrinhweb.run.service.impl;

import com.laptrinhweb.run.converter.CategoryConverter;
import com.laptrinhweb.run.dto.CategoryDTO;
import com.laptrinhweb.run.entity.CategoryEntity;
import com.laptrinhweb.run.repository.CategoryRepository;
import com.laptrinhweb.run.service.ICategorysServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategorysServices {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> listCateE = categoryRepository.findAll();
        List<CategoryDTO> listResult = new ArrayList<>();
        for (CategoryEntity entity :
                listCateE) {
            CategoryDTO cateDTO = categoryConverter.toDto(entity);
            listResult.add(cateDTO);
        }

        return listResult;
    }
}
