package com.rinpo.eam.layblog.vo.layui.table;

import java.io.Serializable;
import java.util.List;

/**
 * 统一的分页查询对象
 * created by Wuwenbin on 2017/8/29 at 21:51
 */
public interface Query extends Serializable {

    /**
     * 当前的页码
     *
     * @return
     */
    int getPageNo();

    /**
     * 当前分页的大小
     *
     * @return
     */
    int getPageSize();

    /**
     * 是否支持服务器排序
     *
     * @return
     */
    boolean isSupportServerSort();

    /**
     * 有些前端的分页表格插件式不支持多列一起排序的，所以需要有个方法判断下
     *
     * @return
     */
    boolean isSupportMultiSort();

    /**
     * 如果支持多列一起排序，那么现在是不是多列排序呢，所以又有一个方法来做判断
     *
     * @return
     */
    boolean isCurrentMultiSort();


    /**
     * 如果{@link #isSupportMultiSort()}为真，则返回null
     * 如果{@link #isSupportMultiSort()}为假，则返回排序信息
     *
     * @return
     */
    Sorting getSortingInfo();

    /**
     * 此方法的返回结果和上面的{@link #getSortingInfo()}情况相反
     *
     * @return
     */
    List<Sorting> getSortingInformation();

}
