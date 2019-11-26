package com.zhxiansheng.startspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author ZhengH
 * @Date 2019/11/25 20:04
 **/
@Configuration
public class MyMVCConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/zh","index");
    }
}
