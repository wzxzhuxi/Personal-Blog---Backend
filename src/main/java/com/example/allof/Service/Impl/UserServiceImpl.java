package com.example.allof.Service.Impl;

import com.example.allof.Mapping.UserMapping;
import com.example.allof.Pojo.User;
import com.example.allof.Service.UserService;
import com.example.allof.Utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapping userMapping;

    @Override
    public User FindByUserName(String username) {
        return userMapping.FindByUserName(username);
    }

    @Override
    public void RegisterUser(String username, String password, String email) {
        userMapping.RegisterUser(username,password,email);
    }

    @Override
    public User Login(String username, String password) {
        return userMapping.Login(username,password);
    }

    @Override
    public boolean Delete(Integer userID) {
        return userMapping.Delete(userID);
    }

    @Override
    public void Update(String username, String password) {
        userMapping.Update(username,password);
    }


}
