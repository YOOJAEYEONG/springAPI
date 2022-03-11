package com.spring.ref.mapper;

import com.spring.ref.model.CodeDTO;
import com.spring.ref.model.CodeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeMapper {
  public List<CodeVO> getCodeList();
  public int insertCode(CodeDTO codeDTO);
}
