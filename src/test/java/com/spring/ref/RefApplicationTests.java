package com.spring.ref;

import com.spring.ref.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import org.slf4j.Logger;


@SpringBootTest
class RefApplicationTests {

  @Resource
  TestMapper testMapper;

  Logger log = LoggerFactory.getLogger(this.getClass());


  @Test
  void contextLoads() {

    //log.info("test{}",testMapper.selectTest());

  }

}
