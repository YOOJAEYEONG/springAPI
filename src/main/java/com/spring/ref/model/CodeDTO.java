package com.spring.ref.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CodeDTO extends CodeVO{

  private List<String> whereUsed;
}
