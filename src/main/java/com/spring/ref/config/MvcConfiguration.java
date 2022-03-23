package com.spring.ref.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer 를 사용하면 @EnableWebMvc 가
 * 자동적으로 세팅해주는 설정에 개발자가 원하는 설정을 추가할 수 있게 된다.
 * @see  <a href="https://goodgid.github.io/Spring-WebMvcConfigurer/">참고</a>
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

  //addResourceHandlers

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry
        .addResourceHandler("/swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
      registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

    WebMvcConfigurer.super.addResourceHandlers(registry);
  }

//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
//    WebMvcConfigurer.super.addInterceptors(registry);
//  }
//
//  @Override
//  public void configurePathMatch(PathMatchConfigurer configurer) {
//    WebMvcConfigurer.super.configurePathMatch(configurer);
//  }


//  @Override
//  public void configureViewResolvers(ViewResolverRegistry registry) {
//    registry.jsp("/WEB-INF/",".jsp");
//  }
}
