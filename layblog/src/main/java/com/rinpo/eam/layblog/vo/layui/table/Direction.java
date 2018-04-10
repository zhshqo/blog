package com.rinpo.eam.layblog.vo.layui.table;

/**
 * 排序的方向
 */
public enum Direction {

    /**
     * 顺序
     */
    ASC("asc"),

    /**
     * 倒序
     */
    DESC("desc");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    /**
     * 得到排序方向的文本
     *
     * @return
     */
    public String getDirectionString() {
        return this.direction;
    }

    /**
     * 根据输入的文本，来得到排序方向的枚举值，默认asc
     *
     * @param direction
     * @return
     */
    public static Direction getDirectionByString(String direction) {
        return "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
    }
}
