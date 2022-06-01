package com.spring.ref;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//@SpringBootTest

class RefApplicationTests {



  public static void main(String[] args) {


    System.out.println(">>>>getCode:"+XSSType.GT.getCode());
    System.out.println(">>>>getType:"+XSSType.GT.getType());
    System.out.println(">>>>toString:"+XSSType.GT.toString());
    System.out.println(">>>>ordinal:"+XSSType.GT.ordinal());
    System.out.println(">>>>:"+XSSType.GT);
    System.out.println(">>>>escape:"+XSSType.escape("<"));//LT
    System.out.println(">>>>unescape:"+XSSType.unescape("&lt;"));//LT
    System.out.println(">>>>valueOf:"+XSSType.valueOf(XSSType.class, "LT"));
    System.out.println(">>>>valueOf:"+XSSType.valueOf(XSSType.class, "GT"));

  }




}


enum XSSType{

  LT("<","&lt;"),
  GT(">","&gt;");

  private final String type;
  private final String code;



  XSSType(String type, String code) {
    this.type = type;
    this.code = code;
  }

  public String getCode() { return code; }

  public String getType() { return type; }


  /**
   * 매번 순회하면서 검색하는것을 지양하기위해 캐싱해 놓는 방법을 구사함
   * Function.identity() : 현재 인자로 들어온 값을 그대로 반환한다.
   */
  private static final Map<String, XSSType> BY_TYPE = Stream.of(values()).collect(Collectors.toMap(XSSType::getType, Function.identity()));
  private static final Map<String, XSSType> BY_CODE = Stream.of(values()).collect(Collectors.toMap(XSSType::getCode, Function.identity()));

  public static String escape(String type) {
    return BY_TYPE.get(type).getCode();
  }

  public static String unescape(String code) {
    return BY_CODE.get(code).getType();
  }
}
