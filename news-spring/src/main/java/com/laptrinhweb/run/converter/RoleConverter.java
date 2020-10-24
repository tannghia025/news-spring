package com.laptrinhweb.run.converter;

import com.laptrinhweb.run.dto.RoleDTO;
import com.laptrinhweb.run.dto.UserDTO;
import com.laptrinhweb.run.entity.RoleEntity;
import com.laptrinhweb.run.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleConverter  {

    public RoleDTO toDto(RoleEntity roleEntity){
        RoleDTO roleDto = new RoleDTO();
        roleDto.setId(roleEntity.getId());
        roleDto.setName(roleEntity.getName());
        roleDto.setCode(roleEntity.getCode());
//        UserConverter userConverter = new UserConverter();
//        List<UserDTO> users = new ArrayList<>();
//        for(UserEntity userEntity : roleEntity.getUsers()){
//            UserDTO userDTO = userConverter.toDto(userEntity);
//            users.add(userDTO);
//        }
//        roleDto.setUsers(users);
        return roleDto;
    }

    public RoleEntity toEntity(RoleDTO roleDTO){
        RoleEntity entity = new RoleEntity();
        entity.setCode(roleDTO.getCode());
        entity.setName(roleDTO.getName());
//        UserConverter userConverter = new UserConverter();
//        List<UserEntity> users = new ArrayList<>();
//        for(UserDTO userDTO : roleDTO.getUsers()){
//            UserEntity userEntity = userConverter.toEntity(userDTO);
//            users.add(userEntity);
//        }
//        entity.setUsers(users);
        return entity;

    }
}
