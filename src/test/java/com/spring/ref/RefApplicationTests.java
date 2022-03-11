package com.spring.ref;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class RefApplicationTests {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Test
  void contextLoads() {
    System.out.println("dddddddddddddddddd");
    String ddl = "CREATE TABLE CODE ("+
      " ID VARCHAR(17) NOT NULL,"+
      " NM VARCHAR(30),"+
      " VALUE VARCHAR(10),"+
      " PARENT_ID VARCHAR(17) NOT NULL DEFAULT LPAD(''::TEXT, 17, '0'::TEXT),"+
      " DESCRIPTION VARCHAR(100),"+
      " CREATE_DATE TIMESTAMP,"+
      " MODIFY_DATE TIMESTAMP,"+
      " WHERE_USED VARCHAR(100),"+
      " CONSTRAINT CODE_UN UNIQUE (ID)"+
      " )";

    jdbcTemplate.execute(ddl);


    jdbcTemplate.execute("CREATE TABLE USERS ("
      + "	USER_ID VARCHAR(100) NOT NULL,"
      + "	DIVISION CHAR(1) NOT NULL,"
      + "	USER_NAME VARCHAR(50) NULL,"
      + "	\"PASSWORD\" VARCHAR(60) NULL,"
      + "	ENABLED NUMERIC(1) NULL,"
      + "	DESCRIPTION VARCHAR(500) NULL,"
      + "	CREATE_DATE TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP,"
      + "	MODIFY_DATE TIMESTAMP(6) NULL,"
      + "	LOGIN_FAILURE_COUNT NUMERIC(1) NULL DEFAULT 0,"
      + "	LAST_PASS_MODIFY_DATE TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP,"
      + "	EXPIRED_DATE TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP,"
      + "	CONSTRAINT USERS_PKEY PRIMARY KEY (USER_ID)"
      + " )");

  }

}
