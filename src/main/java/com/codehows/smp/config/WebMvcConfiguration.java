package com.codehows.smp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private String path;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win")) {
            path = "C:/home/resource/assets";
        }
        else if(os.contains("linux")) {
            path = "/home/codehows";
        }
        registry.addResourceHandler("/image/**").addResourceLocations("file:///"+ path +"/");
    }
}
