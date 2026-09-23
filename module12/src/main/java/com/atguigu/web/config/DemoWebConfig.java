package com.atguigu.web.config;

import com.atguigu.web.interceptor.InterceptorDemo01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class DemoWebConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorDemo01 interceptorDemo01;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorDemo01);
    }
}
