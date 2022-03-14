package com.spring.ref.config.exception;


public class RestException extends Exception{

  private ErrorConstant error = null;

  public String getCode(){
    return error.getCode();
  }

  public String getMessage(){
    return error.getMessage();
  }
}
