package com.spring.ref.mapper;

import com.spring.ref.model.TestDTO;
import com.spring.ref.model.TestVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TestMapper {

  List<TestVO> selectTestList(TestDTO testDTO);

  Integer selectAll();
}
