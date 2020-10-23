package com.laptrinhweb.run.service;

import com.laptrinhweb.run.dto.CategoryDTO;
import com.laptrinhweb.run.entity.CategoryEntity;

import java.util.List;

public interface ICategorysServices {

    List<CategoryDTO> findAll();


}
