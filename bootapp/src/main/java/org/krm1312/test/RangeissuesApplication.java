package org.krm1312.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.GzipResourceResolver;

@SpringBootApplication
public class RangeissuesApplication {


    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {

        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                super.addResourceHandlers(registry);
                registry.addResourceHandler("/test/**")
                    .addResourceLocations("classpath:/test/")
                        .setCachePeriod(3600)
                        .resourceChain(true)
                        .addResolver(new GzipResourceResolver());
            }
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(RangeissuesApplication.class, args);
    }
}
