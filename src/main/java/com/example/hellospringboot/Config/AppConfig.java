package com.example.hellospringboot.Config;

import com.example.hellospringboot.service.MyService;
import com.example.hellospringboot.service.MyService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public MyService2 myService2() {
        return new MyService2();
    }

}
