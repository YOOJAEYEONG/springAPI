package com.spring.ref.web;

import com.spring.ref.model.TestDTO;
import com.spring.ref.model.TestVO;
import com.spring.ref.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.http.ResponseEntity;
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


  @Operation(summary = "@Operation:summary", description = "@Operation:description",method = "@Operation:method")
  @GetMapping("/selectTestList")
  List<TestVO> selectTestList() throws Exception{
    return testService.selectTestList(TestDTO.builder().name1("48").build());
  }


  @ApiResponse(ref = "@ApiResponse:ref",description = "@ApiResponse:description")//Swagger 확인을 위해 추가함
  @Operation(summary = "@Operation:summary", description = "@Operation:description",method = "@Operation:method")//Swagger 확인을 위해 추가함
  @PostMapping("/selectAll")
  public ResponseEntity selectAll(TestDTO testDTO){
    return ResponseEntity.ok(TestVO.builder().name1("sample1").name2("sample2").build());
  }
}
