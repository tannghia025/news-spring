package com.laptrinhweb.run.service.impl;

import com.laptrinhweb.run.converter.NewConverter;
import com.laptrinhweb.run.dto.NewDTO;
import com.laptrinhweb.run.entity.CategoryEntity;
import com.laptrinhweb.run.entity.NewEntity;
import com.laptrinhweb.run.repository.CategoryRepository;
import com.laptrinhweb.run.repository.NewRepository;
import com.laptrinhweb.run.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {
    @Autowired
    NewRepository newRepository;

    @Autowired
    NewConverter newConverter;

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = newConverter.toEntity(newDTO);
        if (newDTO.getId() != null) {
            NewEntity oldEntity = newRepository.findOne(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO, oldEntity);
        } else {
            CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
            newEntity.setCategory(categoryEntity);

        }

        return newConverter.toDto(newRepository.save(newEntity));
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            newRepository.delete(id);
        }
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> result = new ArrayList<>();
        List<NewEntity> entites = newRepository.findAll(pageable).getContent();
        for(NewEntity entity : entites){
            NewDTO newDTO = newConverter.toDto(entity);
            result.add(newDTO);
        }
        return result;
    }

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> result = new ArrayList<>();
        List<NewEntity> entites = newRepository.findAll();
        for (NewEntity entity: entites) {
            NewDTO newDTO = newConverter.toDto(entity);
            result.add(newDTO);
        }

        return result;
    }
}
