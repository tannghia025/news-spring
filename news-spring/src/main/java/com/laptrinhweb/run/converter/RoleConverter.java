package com.laptrinhweb.run.converter;

import com.laptrinhweb.run.dto.RoleDTO;
import com.laptrinhweb.run.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter  {

    public RoleDTO toDto(RoleEntity roleEntity){
        RoleDTO roleDto = new RoleDTO();
        roleDto.setId(roleEntity.getId());
        roleDto.setName(roleEntity.getName());
        roleDto.setCode(roleEntity.getCode());
        return roleDto;
    }
}
