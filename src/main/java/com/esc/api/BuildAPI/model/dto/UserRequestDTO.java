package com.esc.api.BuildAPI.model.dto;

public class UserRequestDTO {
    private String user_name;
    private String email;

    public UserRequestDTO(String user_name, String email) {
        this.user_name = user_name;
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
