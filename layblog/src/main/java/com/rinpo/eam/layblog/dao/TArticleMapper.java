package com.rinpo.eam.layblog.dao;

import com.rinpo.eam.layblog.model.TArticle;
import com.rinpo.eam.layblog.model.TArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticleMapper {
    long countByExample(TArticleExample example);

    int deleteByExample(TArticleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TArticle record);

    int insertSelective(TArticle record);

    List<TArticle> selectByExampleWithBLOBs(TArticleExample example);

    List<TArticle> selectByExample(TArticleExample example);

    TArticle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByExample(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByPrimaryKeySelective(TArticle record);

    int updateByPrimaryKeyWithBLOBs(TArticle record);

    int updateByPrimaryKey(TArticle record);
}