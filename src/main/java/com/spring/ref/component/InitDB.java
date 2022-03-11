package com.spring.ref.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
@Slf4j
@RequiredArgsConstructor
public class InitDB implements ApplicationRunner {

  final JdbcTemplate jdbcTemplate;
  final DataSource dataSource;


  @Override
  public void run(ApplicationArguments args) throws Exception {
    try(
      Connection con = dataSource.getConnection("sa","1234")

    ){
      String DDL_CODE = "CREATE TABLE CODE ("+
        " ID VARCHAR(17) NOT NULL,"+
        " NM VARCHAR(30),"+
        " VALUE VARCHAR(10),"+
        " PARENT_ID VARCHAR(17) NOT NULL DEFAULT '00000000',"+
        " DESCRIPTION VARCHAR(100),"+
        " CREATE_DATE TIMESTAMP,"+
        " MODIFY_DATE TIMESTAMP,"+
        " WHERE_USED VARCHAR(100),"+
        " CONSTRAINT CODE_UN UNIQUE (ID)"+
        " )";
      con.prepareStatement(DDL_CODE).execute();
//    jdbcTemplate.execute(ddl);

      String DDL_USERS = "CREATE TABLE CODE ("+
        " ID VARCHAR(17) NOT NULL,"+
        " NM VARCHAR(30),"+
        " VALUE VARCHAR(10),"+
        " PARENT_ID VARCHAR(17) NOT NULL DEFAULT '00000000',"+
        " DESCRIPTION VARCHAR(100),"+
        " CREATE_DATE TIMESTAMP,"+
        " MODIFY_DATE TIMESTAMP,"+
        " WHERE_USED VARCHAR(100),"+
        " CONSTRAINT CODE_UN UNIQUE (ID)"+
        " )";
//    jdbcTemplate.execute("CREATE TABLE USERS ("
//      + "	USER_ID VARCHAR(100) NOT NULL,"
//      + "	DIVISION CHAR(1) NOT NULL,"
//      + "	USER_NAME VARCHAR(50) NULL,"
//      + "	\"PASSWORD\" VARCHAR(60) NULL,"
//      + "	ENABLED NUMERIC(1) NULL,"
//      + "	DESCRIPTION VARCHAR(500) NULL,"
//      + "	CREATE_DATE TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP,"
//      + "	MODIFY_DATE TIMESTAMP(6) NULL,"
//      + "	LOGIN_FAILURE_COUNT NUMERIC(1) NULL DEFAULT 0,"
//      + "	LAST_PASS_MODIFY_DATE TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP,"
//      + "	EXPIRED_DATE TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP,"
//      + "	CONSTRAINT USERS_PKEY PRIMARY KEY (USER_ID)"
//      + " );");

//    jdbcTemplate.execute("select * from code");
      con.prepareStatement(DDL_USERS).execute();
    }catch (Exception e){
      log.debug(e.getMessage(),e);
    }
  }
}
