package com.spring.ref.model;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.apache.ibatis.type.Alias;

@Data
@SuperBuilder
@Alias("TestVO")
public class TestVO {
  @Parameter(name = "@Parameter:name",description = "@Parameter:description")
  private String name1;
  private String name2;
}
