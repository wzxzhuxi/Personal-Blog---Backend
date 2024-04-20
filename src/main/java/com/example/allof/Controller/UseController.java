package com.example.allof.Controller;

import com.example.allof.Pojo.Result;
import com.example.allof.Pojo.User;
import com.example.allof.Service.UserService;
import com.example.allof.Utils.JwtUtil;
import com.example.allof.Utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UseController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @PostMapping("/register")
//    public Result register(@RequestBody User user){
//        User u=userService.FindByUserName(user.getUsername());
//        if(u==null){
//            userService.RegisterUser(user.getUsername(),Md5Util.getMD5String(user.getPassword()), user.getEmail());
//            return Result.success("注册成功");
//        }
//        return Result.error("用户已存在");
//    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u=userService.FindByUserName(user.getUsername());
        if(u==null){
            return Result.error("用户不存在");
        }
        if(userService.Login(user.getUsername(), Md5Util.getMD5String(user.getPassword()))!=null){
            //登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getUser_id());
            claims.put("username", u.getUsername());
            String token = JwtUtil.genToken(claims);
            //把token存储到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token,token,24, TimeUnit.HOURS);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    //需完善，作为外键被依赖,暂不演示
    @DeleteMapping("/delete")
    public Result delete(String username,String password){
        User user=userService.Login(username,password);
        if(userService.Delete(user.getUser_id())){
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user,@RequestHeader("token")String token){
        User u=userService.Login(user.getUsername(),Md5Util.getMD5String(user.getPassword()));
        if(u!=null){
            userService.Update(user.getUsername(),Md5Util.getMD5String(user.getNew_password()));
            ValueOperations<String,String> operations= stringRedisTemplate.opsForValue();
            operations.getOperations().delete(token);
            return Result.success("修改密码成功");
        }
        return Result.error("原密码错误");
    }
}
