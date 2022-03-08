package com.spring.ref.config.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestException extends Exception{


  private String errorMessage;
  private String errorCode;

}
