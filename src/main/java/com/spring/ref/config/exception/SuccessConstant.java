package com.spring.ref.config.exception;

import lombok.Getter;

@Getter
public enum SuccessConstant {


  LOGIN ( "S001" , "로그인 되었습니다."),
  LOGOUT("S002" , "로그아웃 되었습니다."),
  AUTHORIZED("S003" , "승인되었습니다.");

  private final String code;
  private final String message;


  SuccessConstant(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
