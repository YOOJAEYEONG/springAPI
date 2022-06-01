package com.spring.ref.config.util;

/**
 * XSS 공격 방어 문자열 치환 클래스
 */
public class XSS {

  public static String escape(String value){
    if(value ==  null) return "";
    return value
      .replaceAll("<","&lt;")
      .replaceAll(">","&gt;");
  }

  public static String unescape(String value){
    if(value ==  null) return "";
    return value
      .replaceAll("&lt;","<")
      .replaceAll("&gt;",">");
  }
}
