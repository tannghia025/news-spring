package com.laptrinhweb.run.service.impl;

import com.laptrinhweb.run.converter.RoleConverter;
import com.laptrinhweb.run.converter.UserConverter;
import com.laptrinhweb.run.dto.RoleDTO;
import com.laptrinhweb.run.dto.UserDTO;
import com.laptrinhweb.run.entity.UserEntity;
import com.laptrinhweb.run.repository.RoleRepository;
import com.laptrinhweb.run.repository.UserRepository;
import com.laptrinhweb.run.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleConverter roleConverter;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> listResult = new ArrayList<>();
        List<UserEntity> listEntity = userRepository.findAll();

        for (UserEntity entity:
             listEntity) {
            UserDTO userDTO = userConverter.toDto(entity);
            listResult.add(userDTO);
        }
        return listResult;
    }

    @Override
    public UserDTO findOne(long id) {
        return userConverter.toDto(userRepository.findOne(id));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        //find list role for new user
        List<RoleDTO> listRole = new ArrayList<>();
        RoleDTO roleDTO = roleConverter.toDto(roleRepository.findFirstByCode(userDTO.getRoleCode()));
        listRole.add(roleDTO);
        userDTO.setRoles(listRole);
        //endcode password
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        UserEntity entity = userConverter.toEntity(userDTO);
        if(userDTO.getId()!=null){
            UserEntity entityOld = userRepository.findOne(userDTO.getId());
            entity = userConverter.toEntity(userDTO,entityOld);
        }else{
            entity = userConverter.toEntity(userDTO);

        }
        return userConverter.toDto(userRepository.save(entity));
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids){
            userRepository.delete(id);
        }
    }
}
