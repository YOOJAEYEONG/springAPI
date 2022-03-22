package com.spring.ref.mapper;

import com.spring.ref.model.TestVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface TestMapper {

  List<TestVO> selectTest(Map<String,String> param);
}
