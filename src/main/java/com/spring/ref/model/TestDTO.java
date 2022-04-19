package com.spring.ref.model;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("TestDTO")
@Data
@Builder
public class TestDTO{

  private String name1;
  private String name2;
  private String params;


}
