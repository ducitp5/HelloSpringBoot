package org.o7planning.springbootinterceptors.config;

import org.o7planning.springbootinterceptors.interceptor.AdminInterceptor;
import org.o7planning.springbootinterceptors.interceptor.LogInterceptor;
import org.o7planning.springbootinterceptors.interceptor.OldLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // LogInterceptor apply to all URLs.
        registry.addInterceptor(new LogInterceptor());

        // Old Login url, no longer use.
        // Use OldURLInterceptor to redirect to a new URL.
        registry.addInterceptor(new OldLoginInterceptor())
                .addPathPatterns("/admin/oldLogin");

        // This interceptor apply to URL like /admin/*
        // Exclude /admin/oldLogin
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/*")//
                .excludePathPatterns("/admin/oldLogin");
    }

}