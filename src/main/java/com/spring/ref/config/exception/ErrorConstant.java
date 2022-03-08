package com.spring.ref.config.exception;

import org.springframework.http.HttpStatus;


public enum ErrorConstant {

  AUTHENTICATION_REQUIRED ( HttpStatus.UNAUTHORIZED , "A000001" , "로그인 또는 토큰 정보가 필요합니다."),
  ACCESS_DENIED(HttpStatus.FORBIDDEN , "A000002" , "접근 권한이 없습니다."),
  USER_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR , "R000001" , "사용자 정보가 없습니다."),
  ;

  ErrorConstant(HttpStatus type, String code, String s) {
  }
}
