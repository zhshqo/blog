package com.rinpo.eam.layblog.vo.frontend;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.rinpo.eam.layblog.model.TCate;

public class IndexVo implements Serializable {

    private Map<String, Object> settings;
    private long blogCount;
    private List<TCate> cateList;
    private List<Map<String, Object>> randomArticles;
    private List<Map<String, Object>> tagList;
    private Boolean su;
    
	public Map<String, Object> getSettings() {
		return settings;
	}
	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}
	public long getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(long blogCount) {
		this.blogCount = blogCount;
	}
	public List<TCate> getCateList() {
		return cateList;
	}
	public void setCateList(List<TCate> cateList) {
		this.cateList = cateList;
	}
	public List<Map<String, Object>> getRandomArticles() {
		return randomArticles;
	}
	public void setRandomArticles(List<Map<String, Object>> randomArticles) {
		this.randomArticles = randomArticles;
	}
	public List<Map<String, Object>> getTagList() {
		return tagList;
	}
	public void setTagList(List<Map<String, Object>> tagList) {
		this.tagList = tagList;
	}
	public Boolean getSu() {
		return su;
	}
	public void setSu(Boolean su) {
		this.su = su;
	}

}