package com.spring.ref.web;

import com.spring.ref.model.TestDTO;
import com.spring.ref.model.TestVO;
import com.spring.ref.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/testapi")
public class TestRestController {

  final TestService testService;

  @GetMapping("/selectTestList")
  List<TestVO> selectTestList() throws Exception{
    return testService.selectTestList();
  }
}
