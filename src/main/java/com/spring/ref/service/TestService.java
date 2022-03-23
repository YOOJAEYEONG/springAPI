package com.spring.ref.service;

import com.spring.ref.model.TestDTO;
import com.spring.ref.model.TestVO;

import java.util.List;

public interface TestService {

  List<TestVO> selectTestList(TestDTO testDTO);
}
