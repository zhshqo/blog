package com.rinpo.eam.layblog.dao;

import com.rinpo.eam.layblog.model.TTag;
import com.rinpo.eam.layblog.model.TTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTagMapper {
    long countByExample(TTagExample example);

    int deleteByExample(TTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTag record);

    int insertSelective(TTag record);

    List<TTag> selectByExample(TTagExample example);

    TTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTag record, @Param("example") TTagExample example);

    int updateByExample(@Param("record") TTag record, @Param("example") TTagExample example);

    int updateByPrimaryKeySelective(TTag record);

    int updateByPrimaryKey(TTag record);
    
    /**
     * 【自定义查询】根据文章id查询标签
     * @param articleId
     * @return
     */
    List<TTag> selectByArticleId(String articleId);
}