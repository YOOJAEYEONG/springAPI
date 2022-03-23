package com.spring.ref.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.apache.ibatis.type.Alias;

import java.util.Map;

@Alias("TestDTO")
@Data
//상속받은 클래스 생성시 부모 인자를 셋팅할수 있도록 해줌
@SuperBuilder
public class TestDTO extends TestVO{

  public Map<String,String> params;


}
