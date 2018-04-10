package com.rinpo.eam.layblog.service.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinpo.eam.layblog.dao.TCommentMapper;
import com.rinpo.eam.layblog.model.TComment;
import com.rinpo.eam.layblog.model.TCommentExample;

@Service
public class CommentService {

	@Autowired
	TCommentMapper commentMapper;
	
	/**
	 * 根据文章id查询评论
	 * @param articleId
	 * @return
	 */
	public List<TComment> selectByArticle(String articleId) {
		TCommentExample example = new TCommentExample();
		TCommentExample.Criteria criteria = example.createCriteria();
		criteria.andArticleIdEqualTo(articleId);
		return commentMapper.selectByExample(example);
	}
}
