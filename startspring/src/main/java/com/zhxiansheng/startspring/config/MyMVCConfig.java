package com.zhxiansheng.startspring.config;

import com.zhxiansheng.startspring.compoment.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author ZhengH
 * @Date 2019/11/25 20:04
 **/
@Configuration
public class MyMVCConfig implements WebMvcConfigurer{

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("/index.html").setViewName("login.html");
        registry.addViewController("/main.html").setViewName("dashboard.html");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/main.html");
    }
}
