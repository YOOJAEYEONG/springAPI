package com.spring.ref.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorConstant {

  AUTHENTICATION_REQUIRED ( HttpStatus.UNAUTHORIZED , "E001" , "로그인 또는 토큰 정보가 필요합니다."),
  ACCESS_DENIED(HttpStatus.FORBIDDEN , "E002" , "접근 권한이 없습니다."),
  USER_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR , "E003" , "사용자 정보가 없습니다.");

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;

  ErrorConstant(HttpStatus httpStatus, String code, String message) {
    this.code = code;
    this.httpStatus = httpStatus;
    this.message = message;
  }
}
