package com.laptrinhweb.run.service;

import com.laptrinhweb.run.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    UserDTO findOne(long id);
    UserDTO save(UserDTO userDTO);
    void delete(long [] ids);
}
