package com.rinpo.eam.layblog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("CATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("CATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Integer value) {
            addCriterion("CATE_ID =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Integer value) {
            addCriterion("CATE_ID <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Integer value) {
            addCriterion("CATE_ID >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CATE_ID >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Integer value) {
            addCriterion("CATE_ID <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Integer value) {
            addCriterion("CATE_ID <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Integer> values) {
            addCriterion("CATE_ID in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Integer> values) {
            addCriterion("CATE_ID not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Integer value1, Integer value2) {
            addCriterion("CATE_ID between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CATE_ID not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("COVER is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("COVER is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("COVER =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("COVER <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("COVER >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("COVER >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("COVER <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("COVER <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("COVER like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("COVER not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("COVER in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("COVER not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("COVER between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("COVER not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("AUTHOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("AUTHOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("AUTHOR_ID =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("AUTHOR_ID <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("AUTHOR_ID >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTHOR_ID >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("AUTHOR_ID <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("AUTHOR_ID <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("AUTHOR_ID in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("AUTHOR_ID not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("AUTHOR_ID between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTHOR_ID not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNull() {
            addCriterion("POST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNotNull() {
            addCriterion("POST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPostTimeEqualTo(Date value) {
            addCriterion("POST_TIME =", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotEqualTo(Date value) {
            addCriterion("POST_TIME <>", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThan(Date value) {
            addCriterion("POST_TIME >", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("POST_TIME >=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThan(Date value) {
            addCriterion("POST_TIME <", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("POST_TIME <=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeIn(List<Date> values) {
            addCriterion("POST_TIME in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotIn(List<Date> values) {
            addCriterion("POST_TIME not in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeBetween(Date value1, Date value2) {
            addCriterion("POST_TIME between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("POST_TIME not between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andViewsCntIsNull() {
            addCriterion("VIEWS_CNT is null");
            return (Criteria) this;
        }

        public Criteria andViewsCntIsNotNull() {
            addCriterion("VIEWS_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andViewsCntEqualTo(Integer value) {
            addCriterion("VIEWS_CNT =", value, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntNotEqualTo(Integer value) {
            addCriterion("VIEWS_CNT <>", value, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntGreaterThan(Integer value) {
            addCriterion("VIEWS_CNT >", value, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIEWS_CNT >=", value, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntLessThan(Integer value) {
            addCriterion("VIEWS_CNT <", value, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntLessThanOrEqualTo(Integer value) {
            addCriterion("VIEWS_CNT <=", value, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntIn(List<Integer> values) {
            addCriterion("VIEWS_CNT in", values, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntNotIn(List<Integer> values) {
            addCriterion("VIEWS_CNT not in", values, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntBetween(Integer value1, Integer value2) {
            addCriterion("VIEWS_CNT between", value1, value2, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andViewsCntNotBetween(Integer value1, Integer value2) {
            addCriterion("VIEWS_CNT not between", value1, value2, "viewsCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntIsNull() {
            addCriterion("APPROVE_CNT is null");
            return (Criteria) this;
        }

        public Criteria andApproveCntIsNotNull() {
            addCriterion("APPROVE_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andApproveCntEqualTo(Integer value) {
            addCriterion("APPROVE_CNT =", value, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntNotEqualTo(Integer value) {
            addCriterion("APPROVE_CNT <>", value, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntGreaterThan(Integer value) {
            addCriterion("APPROVE_CNT >", value, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPROVE_CNT >=", value, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntLessThan(Integer value) {
            addCriterion("APPROVE_CNT <", value, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntLessThanOrEqualTo(Integer value) {
            addCriterion("APPROVE_CNT <=", value, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntIn(List<Integer> values) {
            addCriterion("APPROVE_CNT in", values, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntNotIn(List<Integer> values) {
            addCriterion("APPROVE_CNT not in", values, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntBetween(Integer value1, Integer value2) {
            addCriterion("APPROVE_CNT between", value1, value2, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andApproveCntNotBetween(Integer value1, Integer value2) {
            addCriterion("APPROVE_CNT not between", value1, value2, "approveCnt");
            return (Criteria) this;
        }

        public Criteria andAppreciableIsNull() {
            addCriterion("APPRECIABLE is null");
            return (Criteria) this;
        }

        public Criteria andAppreciableIsNotNull() {
            addCriterion("APPRECIABLE is not null");
            return (Criteria) this;
        }

        public Criteria andAppreciableEqualTo(Boolean value) {
            addCriterion("APPRECIABLE =", value, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableNotEqualTo(Boolean value) {
            addCriterion("APPRECIABLE <>", value, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableGreaterThan(Boolean value) {
            addCriterion("APPRECIABLE >", value, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("APPRECIABLE >=", value, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableLessThan(Boolean value) {
            addCriterion("APPRECIABLE <", value, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableLessThanOrEqualTo(Boolean value) {
            addCriterion("APPRECIABLE <=", value, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableIn(List<Boolean> values) {
            addCriterion("APPRECIABLE in", values, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableNotIn(List<Boolean> values) {
            addCriterion("APPRECIABLE not in", values, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableBetween(Boolean value1, Boolean value2) {
            addCriterion("APPRECIABLE between", value1, value2, "appreciable");
            return (Criteria) this;
        }

        public Criteria andAppreciableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("APPRECIABLE not between", value1, value2, "appreciable");
            return (Criteria) this;
        }

        public Criteria andCommentedIsNull() {
            addCriterion("COMMENTED is null");
            return (Criteria) this;
        }

        public Criteria andCommentedIsNotNull() {
            addCriterion("COMMENTED is not null");
            return (Criteria) this;
        }

        public Criteria andCommentedEqualTo(Boolean value) {
            addCriterion("COMMENTED =", value, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedNotEqualTo(Boolean value) {
            addCriterion("COMMENTED <>", value, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedGreaterThan(Boolean value) {
            addCriterion("COMMENTED >", value, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("COMMENTED >=", value, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedLessThan(Boolean value) {
            addCriterion("COMMENTED <", value, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedLessThanOrEqualTo(Boolean value) {
            addCriterion("COMMENTED <=", value, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedIn(List<Boolean> values) {
            addCriterion("COMMENTED in", values, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedNotIn(List<Boolean> values) {
            addCriterion("COMMENTED not in", values, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedBetween(Boolean value1, Boolean value2) {
            addCriterion("COMMENTED between", value1, value2, "commented");
            return (Criteria) this;
        }

        public Criteria andCommentedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("COMMENTED not between", value1, value2, "commented");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}