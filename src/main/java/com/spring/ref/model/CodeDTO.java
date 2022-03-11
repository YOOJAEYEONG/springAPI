package com.spring.ref.model;

import lombok.Data;

import java.util.List;

@Data
public class CodeDTO {
  private String id;
  private String nm;
  private String value;
  private String parentId;
  private String description;
  private List<String> whereUsed;
}
