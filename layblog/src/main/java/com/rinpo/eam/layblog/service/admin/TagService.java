package com.rinpo.eam.layblog.service.admin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rinpo.eam.layblog.dao.TTagMapper;
import com.rinpo.eam.layblog.model.TArticle;
import com.rinpo.eam.layblog.model.TTag;
import com.rinpo.eam.layblog.model.TTagExample;

@Service
public class TagService {

	@Autowired
    private TTagMapper tagMapper;
	
	/**
	 * 根据标签名称查询标签的数量
	 * @param tagName
	 * @return
	 */
	public long countByName(String tagName) {
		TTagExample example = new TTagExample();
		TTagExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(tagName);
        return tagMapper.countByExample(example);
	}
	
	/**
	 * 插入标签
	 * @param tag
	 * @return
	 */
	public long insert(TTag tag) {
        return tagMapper.insert(tag);
	}
	
	/**
	 * 查询ID
	 * @param tagName
	 * @return
	 */
	public int selectId(String tagName) {
		TTagExample example = new TTagExample();
		TTagExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(tagName);
        List<TTag> list = tagMapper.selectByExample(example);
        if(list!=null&&list.size()>0) {
        	return list.get(0).getId();
        } else {
        	return 0;
        }
	}
	
	/**
	 * 根据id查询name
	 * @param id
	 * @return
	 */
	public String selectName(Integer tagId) {
		TTag tag = tagMapper.selectByPrimaryKey(tagId);
		if(tag!=null) {
			return tag.getName();
		} else {
			return null;
		}
	}
	
	/**
	 * 根据文章ID查询标签
	 * @param articleId
	 * @return
	 */
	public List<TTag> findTagsByArticleId(String articleId) {
		return tagMapper.selectByArticleId(articleId);
	}
	
	
	public List<Map<String, Object>> findAllTags() {
		List<TTag> list = tagMapper.selectByExample(new TTagExample());
		if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<Map<String, Object>> newListMap = new LinkedList<>();
        for (TTag tag : list) {
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("id", String.valueOf(tag.getId()));
        	map.put("name", tag.getName());
        	newListMap.add(map);
		}
        return newListMap;
	}
}
