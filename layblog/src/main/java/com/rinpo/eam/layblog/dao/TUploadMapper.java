package com.rinpo.eam.layblog.dao;

import com.rinpo.eam.layblog.model.TUpload;
import com.rinpo.eam.layblog.model.TUploadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUploadMapper {
    long countByExample(TUploadExample example);

    int deleteByExample(TUploadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUpload record);

    int insertSelective(TUpload record);

    List<TUpload> selectByExample(TUploadExample example);

    TUpload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUpload record, @Param("example") TUploadExample example);

    int updateByExample(@Param("record") TUpload record, @Param("example") TUploadExample example);

    int updateByPrimaryKeySelective(TUpload record);

    int updateByPrimaryKey(TUpload record);
}