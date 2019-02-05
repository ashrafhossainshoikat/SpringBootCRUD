package com.ashraf.springbootdemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public ModelMapper myService() {
        return new ModelMapper();
    }

  


}
