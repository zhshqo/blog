package com.rinpo.eam.layblog.dao;

import com.rinpo.eam.layblog.model.TCate;
import com.rinpo.eam.layblog.model.TCateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCateMapper {
    long countByExample(TCateExample example);

    int deleteByExample(TCateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCate record);

    int insertSelective(TCate record);

    List<TCate> selectByExample(TCateExample example);

    TCate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCate record, @Param("example") TCateExample example);

    int updateByExample(@Param("record") TCate record, @Param("example") TCateExample example);

    int updateByPrimaryKeySelective(TCate record);

    int updateByPrimaryKey(TCate record);
}