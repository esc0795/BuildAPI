package com.esc.api.BuildAPI.model.dto;

public class UserResponseDTO {
    private Long id;
    private String user_name;
    private String email;

    public UserResponseDTO(Long id, String user_name, String email) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
