package com.example.allof.Service;

import com.example.allof.Pojo.User;

public interface UserService {
    User FindByUserName(String username);

    void RegisterUser(String username, String password, String email);

    User Login(String username, String password);

    boolean Delete(Integer userID);

    void Update(String username, String password);

}
