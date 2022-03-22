package com.frugalis.Spring.Boot.Resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfigs implements WebMvcConfigurer
{
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS =
    {
        "classpath:/htmlFiles/",
        "classpath:/static/",
        "classpath:/static/images"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/**")
		.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
		.setCachePeriod(3000);
    }
}