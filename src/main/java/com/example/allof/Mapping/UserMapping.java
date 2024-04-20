package com.example.allof.Mapping;

import com.example.allof.Pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapping {

    User FindByUserName(String username);

    void RegisterUser(String username, String password, String email);

    User Login(String username, String password);

    boolean Delete(Integer userID);

    void Update(String username, String password);
}
