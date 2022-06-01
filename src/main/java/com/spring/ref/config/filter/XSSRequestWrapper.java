package com.spring.ref.config.filter;


import com.spring.ref.config.util.XSS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

  /**
   * Constructs a request object wrapping the given request.
   *
   * @param request The request to wrap
   * @throws IllegalArgumentException if the request is null
   */
  public XSSRequestWrapper(HttpServletRequest request) {
    super(request);
  }

  @Override
  public String getHeader(String name) {
    return super.getHeader(name);
  }


  @Override
  public String getQueryString() {
    return XSS.escape(super.getQueryString());
  }

  @Override
  public String getParameter(String name) {
    return XSS.escape(super.getParameter(name));
  }


  @Override
  public Object getAttribute(String name) {
    Object attr = super.getAttribute(name);
    if (attr instanceof String)
      attr = XSS.escape((String)attr);
    return attr;
  }

  //@ModelAttribute 형식으로 바인딩할 경우

  /**
   * 컨트롤러에서 @ModelAttribute DTO(커맨드객체)로 파라미터를 받는경우
   */
  @Override
  public String[] getParameterValues(String name) {
    String[] s = {"sampleValue"};
    //TODO
//    Optional.ofNullable(super.getParameterValues(name))
//      .ifPresent(strings -> Stream.of(super.getParameterValues(name)).peek(XSS::escape).toArray());
//    if(super.getParameterValues(name) != null)
//      return (String[]) Stream.ofNullable(super.getParameterValues(name)).peek(XSS::escape).toArray();
    return s;
  }
}
