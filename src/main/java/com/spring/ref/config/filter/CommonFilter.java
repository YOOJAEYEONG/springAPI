package com.spring.ref.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter("/*")
@Component
public class CommonFilter implements Filter {


  /**
   * 필터가 생성될때 실행됨
   * @param filterConfig
   * @throws ServletException
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  /**
   * Request, Response가 필터를 거칠 때 수행되는 메소드
   * @param request
   * @param response
   * @param chain
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    log.debug("[before]requestParamMap:{}",request.getParameterMap());
    chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
  }


  /**
   * 필터가 소멸될 때 실행됨 (주로 필터가 사용한 자원을 반납)
   */
  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
