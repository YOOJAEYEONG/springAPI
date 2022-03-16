package com.spring.ref.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestDTO extends TestVO{

  private List<String> whereUsed;
}
