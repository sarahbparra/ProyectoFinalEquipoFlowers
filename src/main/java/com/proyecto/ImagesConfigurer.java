package com.proyecto;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class ImagesConfigurer implements WebMvcConfigurer {

    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        
        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler("/recursos/**")

                .addResourceLocations("file:" + "/home/irene/recursos/");

        // El doble asterisco significa que mis recursos están en la carpeta recursos,

        // y en cualquier cosa que se cree a partir de ahí.

    }

}