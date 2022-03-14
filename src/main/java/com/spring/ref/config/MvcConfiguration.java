package com.spring.ref.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * WebMvcConfigurer 를 사용하면 @EnableWebMvc 가
 * 자동적으로 세팅해주는 설정에 개발자가 원하는 설정을 추가할 수 있게 된다.
 * @see  <a href="https://goodgid.github.io/Spring-WebMvcConfigurer/">참고</a>
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {


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
