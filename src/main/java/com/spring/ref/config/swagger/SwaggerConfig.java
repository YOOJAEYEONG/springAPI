package com.spring.ref.config.swagger;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
 * swagger ui
 * http://localhost/context-path/swagger-ui/
 *
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("Example API")
      .description("Swagger 소개를 위한 example")
      .build();
  }

  @Bean
  public Docket apiV1(){
    return new Docket(DocumentationType.SWAGGER_2)
      .groupName("groupName1")
      .select()
      //.apis(RequestHandlerSelectors.basePackage("com.spring.ref"))
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.ant("/**"))
      .build();
  }
}
