package com.tenniscope.tenniscope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    ApiInfo apiInfo () {
        return new ApiInfoBuilder()
                .title("Tenniscope API Referance")
                .version("1.0.0")
                .build();
    }

    @Bean //Don't forget the @Bean annotation
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.tenniscope"))
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }
}

/**
 * @Configuration : uygulama ilk ayaga kalkarken bu anatotation'in bulundugu config dosyasi
 * yuklenecek
 *
 * @EnableSwagger2 : swagger i aktif ediyoruz.
 */