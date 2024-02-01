package com.time.trip.springboot.template.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder()
                // 组名
                .group("test")
                // 扫描的包
                .packagesToScan("com.time.trip.springboot.template.controller.test")
                .build();
    }

    @Bean
    public GroupedOpenApi demoApi() {
        return GroupedOpenApi.builder()
                // 组名
                .group("testext")
                // 扫描的包
                .packagesToScan("com.time.trip.springboot.template.controller.testext")
                .build();
    }

    @Bean
    public OpenAPI springDocOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("springboot template 接口文档")
                        .description("springboot template 接口文档")
                        .version("v1"));
    }

}


