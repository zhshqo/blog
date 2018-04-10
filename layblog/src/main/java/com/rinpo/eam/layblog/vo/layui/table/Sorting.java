package com.rinpo.eam.layblog.vo.layui.table;

/**
 * 排序的对象
 */
public class Sorting {

    private String sortName;
    private Direction sortDirection;

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public static Sorting asc(String sortName) {
        Sorting sorting = new Sorting();
        sorting.setSortName(sortName);
        sorting.setSortDirection(Direction.ASC);
        return sorting;
    }

    public static Sorting desc(String sortName) {
        Sorting sorting = new Sorting();
        sorting.setSortName(sortName);
        sorting.setSortDirection(Direction.DESC);
        return sorting;
    }

}
