package com.laptrinhweb.run.dto;

import java.util.List;

public class RoleDTO extends AbstractDTO<RoleDTO> {

    private String code;
    private String name;

    private List<UserDTO> users;

    public List<UserDTO> getUsers() {
        return users;
    }
    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                +getId()+'}';
    }
}
