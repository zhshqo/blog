package com.rinpo.eam.layblog.dao;

import com.rinpo.eam.layblog.model.TTagRefer;
import com.rinpo.eam.layblog.model.TTagReferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTagReferMapper {
    long countByExample(TTagReferExample example);

    int deleteByExample(TTagReferExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTagRefer record);

    int insertSelective(TTagRefer record);

    List<TTagRefer> selectByExample(TTagReferExample example);

    TTagRefer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTagRefer record, @Param("example") TTagReferExample example);

    int updateByExample(@Param("record") TTagRefer record, @Param("example") TTagReferExample example);

    int updateByPrimaryKeySelective(TTagRefer record);

    int updateByPrimaryKey(TTagRefer record);
}