package com.rinpo.eam.layblog.vo.layui.table;

import java.util.List;

/**
 * created by Wuwenbin on 2017/8/30 at 11:41
 * @author wuwenbin
 */
public interface Table<T> {

    /**
     * 表格的当前页数据
     *
     * @return
     */
    List<T> getCurrentPageData();
}
