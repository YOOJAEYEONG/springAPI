package com.spring.ref.model;

import lombok.Data;

@Data
public class CodeVO {
  private String id;
  private String nm;
  private String value;
  private String parent_id;
  private String description;
  private String create_date;
  private String modify_date;
  private String where_used;
}
