package com.rinpo.eam.layblog.vo.frontend;

import java.util.List;

import com.rinpo.eam.layblog.model.TComment;

public class CommentsVo {

	private int totalCount;
	private List<TComment> result;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<TComment> getResult() {
		return result;
	}
	public void setResult(List<TComment> result) {
		this.result = result;
	}
	
}
