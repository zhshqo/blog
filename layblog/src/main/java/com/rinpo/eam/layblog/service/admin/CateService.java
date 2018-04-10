package com.rinpo.eam.layblog.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinpo.eam.layblog.dao.TCateMapper;
import com.rinpo.eam.layblog.model.TCate;
import com.rinpo.eam.layblog.model.TCateExample;

@Service
public class CateService {

	@Autowired
    private TCateMapper cateMapper;
	
	/**
	 * 查询所有的分类
	 * @param tagName
	 * @return
	 */
	public List<TCate> findAll() {
		return cateMapper.selectByExample(new TCateExample());
	}
	
	/**
	 * 根据id查询名称
	 * @param id
	 * @return
	 */
	public String findNameById(Integer id) {
		TCate cate = cateMapper.selectByPrimaryKey(id);
		if(cate!=null) {
			return cate.getCnName();
		} else {
			return null;
		}
	}
}
