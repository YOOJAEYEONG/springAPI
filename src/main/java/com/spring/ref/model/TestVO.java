package com.spring.ref.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("TestVO")
public class TestVO {
  private String name1;
  private String name2;
}
