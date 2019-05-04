package com.example.orangeshare.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有C:/Users/gzpost05/Desktop/springboot博客/ 访问都映射到/myTest/** 路径下
        registry.addResourceHandler("/**.html").addResourceLocations("file:D:/orangeshare/src/main/resources/Html/");
        registry.addResourceHandler("/CSS/**").addResourceLocations("file:D:/orangeshare/src/main/resources/static/CSS/");
        registry.addResourceHandler("/JS/**").addResourceLocations("file:D:/orangeshare/src/main/resources/static/JS/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:/orangeshare/src/main/resources/images/");
    }

}
