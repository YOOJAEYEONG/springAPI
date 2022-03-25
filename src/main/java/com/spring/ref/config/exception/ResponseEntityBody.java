package com.spring.ref.config.exception;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Data
@Slf4j
@Builder
public class ResponseEntityBody {

  private String uuid;
  private String timestamp;   // 요청 시각
  private String error;
  private String trace;
  private String message;
  private String path;
  private int totalCount;
  private Map<String,Object> data;

  public static ResponseEntityBody error(RequestBasicInfo requestBasicInfo , RestException re) {


    return builder()
      .uuid(requestBasicInfo.getUuid())
      .timestamp(requestBasicInfo.getTimestamp())
      .path(requestBasicInfo.getPath())
      .error(re.getCode())
      .message(re.getMessage())
      .build();
  }

  public static ResponseEntityBody error(RequestBasicInfo requestBasicInfo , Exception e) {

    return builder()
      .uuid(requestBasicInfo.getUuid())
      .timestamp(requestBasicInfo.getTimestamp())
      .path(requestBasicInfo.getPath())
      .message(e.getMessage())
      .build();
  }
}
