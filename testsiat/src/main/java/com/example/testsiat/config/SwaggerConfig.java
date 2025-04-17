package com.example.testsiat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        // return new OpenAPI()
        //         .components(new Components()
        //                 .addSchemas("UserRequestDTO", new Schema().type("object")
        //                         .addProperties("id", new StringSchema())
        //                         .addProperties("pwd", new StringSchema())
        //                         .addProperties("name", new StringSchema()))
        //                 .addSchemas("UserResponseDTO", new Schema().type("object")
        //                         .addProperties("id", new StringSchema())
        //                         .addProperties("pwd", new StringSchema())
        //                         .addProperties("name", new StringSchema())));
        return new OpenAPI().info(apiInfo());
    }
    private Info apiInfo() {
        return new Info()
                .title("Test SIAT API")
                .description("Todo")
                .version("1.0.0");
    }
    
}
