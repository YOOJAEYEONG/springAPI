package com.spring.ref.config.exception;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@RequestScope
@Component
public class RequestBasicInfo {
  private String uuid;
  private String timestamp;   //요청시간
  private String path;
}
