package com.spring.ref.config.aop;

import com.spring.ref.component.CommonComponent;
import com.spring.ref.config.exception.RequestBasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class BaseInterceptor implements	HandlerInterceptor {


  private final HttpSession httpSession;					// @Autowired(required = true)
  private final CommonComponent commonComponent;		// @Resource(name="CommonComponent")
  private final RequestBasicInfo requestBasicInfo;

  /**
   * HTTP 요청 처리 전 수행할 로직 작성
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
    log.info("BaseInterCeptor[preHandle] URI " + request.getRequestURI() + " - Call start ======================================");

    initBasicEntity(request);

    log.info("requestBasicInfo : {}" , requestBasicInfo.toString());

    return true;
  }

  /**
   * HTTP 요청 처리 후 수행할 로직 작성
   */
  @Override
  public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {
    log.info("BaseInterceptor[preHandle] URI " + request.getRequestURI() + " Call end ======================================");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                              Exception ex) throws Exception {
    log.info("BaseInterceptor[afterCompletion]");
  }

  /**
   *  path , uuid , timestamp 의 값을 basicEntity 담는다 .
   * @param request
   */
  private void initBasicEntity(HttpServletRequest request) {

    try {

      requestBasicInfo.setUuid(commonComponent.createUUID("V4"));
      requestBasicInfo.setPath(request.getRequestURI());
      requestBasicInfo.setTimestamp(commonComponent.currentTime());

    } catch (Exception e) {
      // TODO: handle exception
      log.error("BaseInterceptor[initBasicEntity]" , e);
    }
  }
}