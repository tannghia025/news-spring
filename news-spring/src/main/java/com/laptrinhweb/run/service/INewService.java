package com.laptrinhweb.run.service;

import com.laptrinhweb.run.dto.NewDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface INewService {
    NewDTO save(NewDTO newDTO);
    void delete(long [] ids);
    int totalItem();
    List<NewDTO> findAll(Pageable pageable);
    List<NewDTO> findAll();
    NewDTO findOne(long id);

}
