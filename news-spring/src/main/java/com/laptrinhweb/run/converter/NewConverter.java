package com.laptrinhweb.run.converter;

import com.laptrinhweb.run.dto.NewDTO;
import com.laptrinhweb.run.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

    public NewDTO toDto(NewEntity entity){
        NewDTO newDTO = new NewDTO();
        if(entity.getId()!=null){
            newDTO.setId(entity.getId());
        }
        newDTO.setTitle(entity.getTitle());
        newDTO.setContent(entity.getContent());
        newDTO.setShortDescription(entity.getShortDescription());
        newDTO.setThumbnail(entity.getThumbnail());
        newDTO.setCreatedBy(entity.getCreatedBy());
        newDTO.setCreatedDate(entity.getCreatedDate());
        newDTO.setModifiedBy(entity.getModifiedBy());
        newDTO.setModifiedDate(entity.getModifiedDate());
        return newDTO;
    }

    public NewEntity toEntity(NewDTO dto,NewEntity newEntity){
        newEntity.setTitle(dto.getTitle());
        newEntity.setContent(dto.getContent());
        newEntity.setShortDescription(dto.getShortDescription());
        newEntity.setThumbnail(dto.getThumbnail());
        return newEntity;
    }

    public NewEntity toEntity(NewDTO dto){
        NewEntity newEntity = new NewEntity();
        newEntity.setTitle(dto.getTitle());
        newEntity.setContent(dto.getContent());
        newEntity.setShortDescription(dto.getShortDescription());
        newEntity.setThumbnail(dto.getThumbnail());
        return newEntity;
    }

}
