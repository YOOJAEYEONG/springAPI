package com.spring.ref.web;


import com.spring.ref.model.XSSTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
public class XSSTestController {

  /**
   * XSS 방어 테스트 : 파라미터로 받는 경우
   * @param request
   * @return
   */
  @RequestMapping("/xss")
  public String testXSS(HttpServletRequest request) {
    log.info("param:{}", request.getParameter("param"));
    return request.getParameter("param");
  }

  /**
   * XSS 방어 테스트 : 커맨드객체로 받는경우
   * @param dto
   * @return
   */
  @RequestMapping("/xss1")
  public String test2(@ModelAttribute XSSTestDTO dto){
    log.info("XSS dto test : {}",dto);
    return dto.getParam();
  }


}
