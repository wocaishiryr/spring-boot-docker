package com.renyr.dockerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.renyr.dockerdemo.web"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring boot2 + docker 集成 API接口")
                .description("文档地址: http://localhost:8080/v2/api-docs")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .contact(new Contact("renyr", "https://blog.csdn.net/wocaishiryr", "wocaishiryr@163.com"))
                .version("v1.0")
                .build();
    }

}