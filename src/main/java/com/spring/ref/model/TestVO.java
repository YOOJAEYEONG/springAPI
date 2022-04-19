package com.spring.ref.model;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@Alias("TestVO")
public class TestVO {
  @Parameter(name = "@Parameter:name1",description = "@Parameter:description1")
  private String name1;
  @Parameter(name = "@Parameter:name2",description = "@Parameter:description2")
  private String name2;

}
