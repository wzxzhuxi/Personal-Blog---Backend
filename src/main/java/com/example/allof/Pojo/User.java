package com.example.allof.Pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class User {

    private Integer user_id;

    private String username;

    private String password;

    private String email;

    private String new_password;
}
