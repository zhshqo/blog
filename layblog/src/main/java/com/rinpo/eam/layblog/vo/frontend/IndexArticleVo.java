package com.rinpo.eam.layblog.vo.frontend;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.rinpo.eam.layblog.model.TTag;
import com.rinpo.eam.layblog.vo.Page;
import com.rinpo.eam.layblog.vo.admin.ArticleVo;

public class IndexArticleVo implements Serializable {
    private Page<ArticleVo> page;
    private Map<String, List<TTag>> tags;
    
	public Page<ArticleVo> getPage() {
		return page;
	}
	public void setPage(Page<ArticleVo> page) {
		this.page = page;
	}
	public Map<String, List<TTag>> getTags() {
		return tags;
	}
	public void setTags(Map<String, List<TTag>> tags) {
		this.tags = tags;
	}
    
}