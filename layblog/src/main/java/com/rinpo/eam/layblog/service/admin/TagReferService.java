package com.rinpo.eam.layblog.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinpo.eam.layblog.dao.TTagReferMapper;
import com.rinpo.eam.layblog.model.TTagRefer;
import com.rinpo.eam.layblog.model.TTagReferExample;

@Service
public class TagReferService {

	@Autowired
    private TTagReferMapper tagReferMapper;
	@Autowired
	private TagService tagService;
	
	/**
	 * 插入标签与文章的关联
	 * @param tag
	 * @return
	 */
	public int insert(TTagRefer tagRefer) {
		//先判断是否已存在
		TTagReferExample example = new TTagReferExample();
		TTagReferExample.Criteria criteria = example.createCriteria();
		criteria.andReferIdEqualTo(tagRefer.getReferId());
		criteria.andTagIdEqualTo(tagRefer.getTagId());
		if(tagReferMapper.countByExample(example)==0) {
			return tagReferMapper.insert(tagRefer);
		} else {
			return 0;
		}
	}
	
	/**
	 * 根据ReferId删除标签
	 * @param referId
	 * @return
	 */
	public int deleteByReferId(String referId) {
		TTagReferExample example = new TTagReferExample();
		TTagReferExample.Criteria criteria = example.createCriteria();
		criteria.andReferIdEqualTo(referId);
		return tagReferMapper.deleteByExample(example);
	}
	
	/**
	 * 根据文章id查找标签名称
	 * @param referId
	 * @return
	 */
	public List<String> findTagNameByReferId(String referId) {
		TTagReferExample example = new TTagReferExample();
		TTagReferExample.Criteria criteria = example.createCriteria();
		criteria.andReferIdEqualTo(referId);
		List<TTagRefer> list = tagReferMapper.selectByExample(example);
		List<String> result = new ArrayList<String>();
		for(TTagRefer tagRefer:list) {
			String tagName = tagService.selectName(tagRefer.getTagId());
			if(tagName!=null) {
				result.add(tagName);
			}
		}
		return result;
	}
}
