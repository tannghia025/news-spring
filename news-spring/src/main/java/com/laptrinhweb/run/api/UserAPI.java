package com.laptrinhweb.run.api;

import com.laptrinhweb.run.dto.UserDTO;
import com.laptrinhweb.run.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAPI {

    @Autowired
    IUserService userService;

    @PostMapping(value = "/api/user")
    private UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }
    @DeleteMapping(value = "/api/user")
    private void deleteUser(@RequestBody long [] ids){
         userService.delete(ids);
    }
}
