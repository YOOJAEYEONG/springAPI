package com.spring.ref.model;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("TestDTO")
@Data
@Builder //상속받은 클래스 생성시 부모 인자를 셋팅할수 있도록 해줌
public class TestDTO{

  private String name1;
  private String name2;
  private String params;


}
