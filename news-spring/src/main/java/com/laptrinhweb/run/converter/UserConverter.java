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
        if(entity.getId()!=null){
            userDTO.setId(entity.getId());
        }
        userDTO.setUsername(entity.getUsername());
        userDTO.setPassword(entity.getPassword());
        userDTO.setStatus(entity.getStatus());
        userDTO.setFullname(entity.getFullname());
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

    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();

        entity.setAddress(dto.getAddress());
        entity.setAge(dto.getAge());
        entity.setCmnd(dto.getCmnd());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setFullname(dto.getFullname());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setStatus(dto.getStatus());

        List<RoleEntity> roles = new ArrayList<>();
        RoleConverter roleConverter = new RoleConverter();
        for (RoleDTO roleDTO: dto.getRoles()) {
            RoleEntity roleEntity = roleConverter.toEntity(roleDTO);
            roles.add(roleEntity);
        }
        entity.setRoles(roles);
        return entity;
    }
    public UserEntity toEntity(UserDTO dto,UserEntity entity){
        entity.setAddress(dto.getAddress());
        entity.setAge(dto.getAge());
        entity.setCmnd(dto.getCmnd());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setFullname(dto.getFullname());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setStatus(dto.getStatus());

        return entity;
    }




}

