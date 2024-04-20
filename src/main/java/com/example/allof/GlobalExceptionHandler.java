package com.example.allof;

import com.example.allof.Pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice是一个组合注解，它包括@ControllerAdvice和@ResponseBody，
// 表明该类的方法可以处理整个应用的异常，并且响应是自动序列化成JSON格式返回给客户端。
@RestControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler注解用于指定由该方法处理的异常类型，这里指定为Exception.class，
    // 表明该方法可以处理所有的Exception及其子类异常。
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        // 打印异常堆栈信息到控制台，这有助于开发人员调试错误。
        e.printStackTrace();

        // 创建并返回一个错误响应对象。
        // StringUtils.hasLength检查异常消息是否非空，如果非空则返回该消息，
        // 否则返回默认的"操作失败"消息。
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}

