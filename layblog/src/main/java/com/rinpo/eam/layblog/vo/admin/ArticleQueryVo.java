package com.rinpo.eam.layblog.vo.admin;

import com.rinpo.eam.layblog.vo.layui.table.LayTableQuery;

public class ArticleQueryVo extends LayTableQuery {

    private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}

