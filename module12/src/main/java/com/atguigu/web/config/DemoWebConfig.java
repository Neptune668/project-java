package com.atguigu.web.config;

import com.atguigu.web.interceptor.InterceptorDemo01;
import com.atguigu.web.interceptor.InterceptorDemo02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class DemoWebConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorDemo01 interceptorDemo01;
    @Autowired
    private InterceptorDemo02 interceptorDemo02;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册和添加拦截的地址
        registry.addInterceptor(interceptorDemo02).addPathPatterns("/*");
        registry.addInterceptor(interceptorDemo01).addPathPatterns("/**");
    }
}
