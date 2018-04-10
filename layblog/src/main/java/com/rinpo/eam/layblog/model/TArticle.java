package com.rinpo.eam.layblog.model;

import java.util.Date;

public class TArticle {
    private String id;

    private String title;

    private Integer cateId;

    private String cover;

    private String summary;

    private Integer authorId;

    private Date postTime;

    private Date modifyTime;

    private Integer viewsCnt;

    private Integer approveCnt;

    private Boolean appreciable;

    private Boolean commented;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getViewsCnt() {
        return viewsCnt;
    }

    public void setViewsCnt(Integer viewsCnt) {
        this.viewsCnt = viewsCnt;
    }

    public Integer getApproveCnt() {
        return approveCnt;
    }

    public void setApproveCnt(Integer approveCnt) {
        this.approveCnt = approveCnt;
    }

    public Boolean getAppreciable() {
        return appreciable;
    }

    public void setAppreciable(Boolean appreciable) {
        this.appreciable = appreciable;
    }

    public Boolean getCommented() {
        return commented;
    }

    public void setCommented(Boolean commented) {
        this.commented = commented;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}