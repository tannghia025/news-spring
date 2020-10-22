package com.laptrinhweb.run.service;

import com.laptrinhweb.run.dto.RoleDTO;
import com.laptrinhweb.run.dto.UserDTO;
import com.laptrinhweb.run.entity.UserEntity;
import com.laptrinhweb.run.converter.UserConverter;
import com.laptrinhweb.run.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username,1);
        if(userEntity==null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found username: " + username);
        UserDTO userDTO = userConverter.toDto(userEntity);

        List<GrantedAuthority> granList = new ArrayList<>();
        for(RoleDTO roleDTO : userDTO.getRoles()){
            GrantedAuthority authority = new SimpleGrantedAuthority(roleDTO.getCode());
            granList.add(authority);
        }
        UserDetails userDetails = (UserDetails) new User(userDTO.getUsername(),userDTO.getPassword(),granList);
        return userDetails;
    }
}
