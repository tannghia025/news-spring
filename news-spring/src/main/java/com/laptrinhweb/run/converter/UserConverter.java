package com.laptrinhweb.run.converter;

import com.laptrinhweb.run.dto.RoleDTO;
import com.laptrinhweb.run.dto.UserDTO;
import com.laptrinhweb.run.entity.RoleEntity;
import com.laptrinhweb.run.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {



    public UserDTO toDto(UserEntity entity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(entity.getUsername());
        userDTO.setPassword(entity.getPassword());
        userDTO.setStatus(entity.getStatus());
        userDTO.setAddress(entity.getModifiedBy());
        userDTO.setAge(entity.getAge());
        userDTO.setCmnd(entity.getCmnd());
        userDTO.setDateOfBirth(entity.getDateOfBirth());
        List<RoleDTO> roles = new ArrayList<>();
        RoleConverter roleConverter = new RoleConverter();
        for (RoleEntity roleEntity: entity.getRoles()) {
            RoleDTO roleDTO = roleConverter.toDto(roleEntity);
            roles.add(roleDTO);
        }
        userDTO.setRoles(roles);
        return userDTO;
    }



}

