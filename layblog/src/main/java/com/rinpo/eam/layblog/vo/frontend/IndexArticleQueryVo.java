package com.rinpo.eam.layblog.vo.frontend;

import java.util.ArrayList;
import java.util.List;

import com.rinpo.eam.layblog.vo.layui.table.LayTableQuery;
import com.rinpo.eam.layblog.vo.layui.table.Sorting;
import com.rinpo.eam.layblog.utils.Injection;
import com.rinpo.eam.layblog.utils.Url;
import com.rinpo.eam.layblog.vo.layui.table.Direction;

/**
 * 先按置顶排序再按时间排序
 * created by Wuwenbin on 2018/2/4 at 14:14
 */
public class IndexArticleQueryVo extends LayTableQuery {

    private String title;
    private String textContent;
    private Long cateId;
    private String tagSearch;


    public void setTitle(String title) {
        title = Url.urlDecode(title, "UTF-8");
        this.title = Injection.stripSqlXSS(title);
    }

    public void setTextContent(String textContent) {
        textContent = Url.urlDecode(textContent, "UTF-8");
        this.textContent = Injection.stripSqlXSS(textContent);
    }

    public void setTagSearch(String tagSearch) {
        tagSearch = Url.urlDecode(tagSearch, "UTF-8");
        this.tagSearch = tagSearch;
    }

    @Override
    public List<Sorting> getSortingInformation() {
        String multiSorts = "top,desc;post,desc";
        String[] sorts = multiSorts.split(";");
        List<Sorting> multiSortList = new ArrayList<>(sorts.length);
        for (String sort : sorts) {
            String[] singleSort = sort.split(",");
            Sorting ms = new Sorting();
            ms.setSortName(singleSort[0]);
            ms.setSortDirection(Direction.getDirectionByString(singleSort[1]));
            multiSortList.add(ms);
        }
        return multiSortList;
    }

    @Override
    public boolean isSupportMultiSort() {
        return true;
    }

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public String getTitle() {
		return title;
	}

	public String getTextContent() {
		return textContent;
	}

	public String getTagSearch() {
		return tagSearch;
	}

}
