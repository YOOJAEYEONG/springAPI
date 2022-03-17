package com.spring.ref.service.impl;

import com.spring.ref.mapper.TestMapper;
import com.spring.ref.model.TestVO;
import com.spring.ref.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

  final TestMapper testMapper;

  @Override
  public List<TestVO> selectTestList() {
    log.trace(">>>>>>>{}",testMapper.selectTest());
    return testMapper.selectTest();
  }
}
