package com.spring.ref.config.exception;

import lombok.Builder;
import lombok.Data;

import static com.spring.ref.config.exception.ErrorConstant.ACCESS_DENIED;
import static com.spring.ref.config.exception.ErrorConstant.AUTHENTICATION_REQUIRED;

@Data
@Builder
public class RestException extends Exception{


  private String errorMessage;
  private String errorCode;


}
