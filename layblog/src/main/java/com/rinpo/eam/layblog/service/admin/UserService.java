package com.rinpo.eam.layblog.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinpo.eam.layblog.dao.TUserMapper;
import com.rinpo.eam.layblog.model.TUser;
import com.rinpo.eam.layblog.model.TUserExample;

@Service
public class UserService {
	@Autowired
	TUserMapper userMapper;
	
	public String findNicknameById(Integer userId) {
		TUser user = userMapper.selectByPrimaryKey(userId);
		if(user!=null) {
			return user.getNickname();
		} else {
			return null;
		}
	}
	
	public TUser findByUsernameAndPasswordAndEnable(String username, String password, Integer enable) {
		TUserExample example = new TUserExample();
		TUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		criteria.andEnableEqualTo(enable);
		List<TUser> list = userMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
