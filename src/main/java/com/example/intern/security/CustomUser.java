package com.example.intern.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="custom_user")
@Data
public class CustomUser {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public CustomUser(String username, String encode) {
    }

    public CustomUser() {

    }
}
