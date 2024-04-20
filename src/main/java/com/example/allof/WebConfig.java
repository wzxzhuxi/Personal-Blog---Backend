package com.example.allof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 使用Spring的@Autowired注解自动注入LoginInterceptor对象
    // 这要求Spring容器中必须有一个LoginInterceptor的Bean实例化可用
    @Autowired
    private LoginInterceptor loginInterceptor;

    // 重写WebMvcConfigurer接口的addInterceptors方法，用于添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册LoginInterceptor拦截器，并设置拦截器不拦截特定的路径模式
        // 这样，登录和注册请求不会被拦截器阻塞，允许未登录用户访问这些路径
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register","/text/select");
    }

    // 重写WebMvcConfigurer接口的addCorsMappings方法，用于配置CORS策略
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 为所有路径添加CORS映射，允许来自指定源的跨域请求
        // 这里的配置仅允许来自"http://localhost:8080"的请求访问
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080");
    }
}


