package com.spring.ref.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 구성 설정
 * http://localhost:[port]/[context-path]/swagger-ui/index.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .version("version - 1.0")
      .title("API - Title")
      .description("Swagger Api - description")
      .build();
  }

  @Bean
  public Docket api1(){
    return new Docket(DocumentationType.SWAGGER_2)
      // Swagger 에서 제공해주는 기본 응답 코드 (200, 401, 403, 404). false 로 설정하면 기본 응답 코드를 노출하지 않음
      .useDefaultResponseMessages(false)
      .apiInfo(apiInfo())
      .groupName("Docket - groupName1")
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.spring.ref"))// api 스펙이 작성되어 있는 패키지 (Controller) 를 지정
      //.apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any()) //apis 에 있는 API 중 특정 path 를 선택
      .build();
  }

  @Bean
  public Docket api2(){
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .groupName("Docket - groupName2")
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any()) //apis 에 있는 API 중 특정 path 를 선택
      .build();
  }



}
