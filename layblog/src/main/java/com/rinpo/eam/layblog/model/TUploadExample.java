package com.rinpo.eam.layblog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUploadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUploadExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDiskPathIsNull() {
            addCriterion("DISK_PATH is null");
            return (Criteria) this;
        }

        public Criteria andDiskPathIsNotNull() {
            addCriterion("DISK_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andDiskPathEqualTo(String value) {
            addCriterion("DISK_PATH =", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotEqualTo(String value) {
            addCriterion("DISK_PATH <>", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathGreaterThan(String value) {
            addCriterion("DISK_PATH >", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathGreaterThanOrEqualTo(String value) {
            addCriterion("DISK_PATH >=", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathLessThan(String value) {
            addCriterion("DISK_PATH <", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathLessThanOrEqualTo(String value) {
            addCriterion("DISK_PATH <=", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathLike(String value) {
            addCriterion("DISK_PATH like", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotLike(String value) {
            addCriterion("DISK_PATH not like", value, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathIn(List<String> values) {
            addCriterion("DISK_PATH in", values, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotIn(List<String> values) {
            addCriterion("DISK_PATH not in", values, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathBetween(String value1, String value2) {
            addCriterion("DISK_PATH between", value1, value2, "diskPath");
            return (Criteria) this;
        }

        public Criteria andDiskPathNotBetween(String value1, String value2) {
            addCriterion("DISK_PATH not between", value1, value2, "diskPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathIsNull() {
            addCriterion("VIRTUAL_PATH is null");
            return (Criteria) this;
        }

        public Criteria andVirtualPathIsNotNull() {
            addCriterion("VIRTUAL_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualPathEqualTo(String value) {
            addCriterion("VIRTUAL_PATH =", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotEqualTo(String value) {
            addCriterion("VIRTUAL_PATH <>", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathGreaterThan(String value) {
            addCriterion("VIRTUAL_PATH >", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathGreaterThanOrEqualTo(String value) {
            addCriterion("VIRTUAL_PATH >=", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathLessThan(String value) {
            addCriterion("VIRTUAL_PATH <", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathLessThanOrEqualTo(String value) {
            addCriterion("VIRTUAL_PATH <=", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathLike(String value) {
            addCriterion("VIRTUAL_PATH like", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotLike(String value) {
            addCriterion("VIRTUAL_PATH not like", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathIn(List<String> values) {
            addCriterion("VIRTUAL_PATH in", values, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotIn(List<String> values) {
            addCriterion("VIRTUAL_PATH not in", values, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathBetween(String value1, String value2) {
            addCriterion("VIRTUAL_PATH between", value1, value2, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotBetween(String value1, String value2) {
            addCriterion("VIRTUAL_PATH not between", value1, value2, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andUploadIsNull() {
            addCriterion("UPLOAD is null");
            return (Criteria) this;
        }

        public Criteria andUploadIsNotNull() {
            addCriterion("UPLOAD is not null");
            return (Criteria) this;
        }

        public Criteria andUploadEqualTo(Date value) {
            addCriterion("UPLOAD =", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotEqualTo(Date value) {
            addCriterion("UPLOAD <>", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadGreaterThan(Date value) {
            addCriterion("UPLOAD >", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadGreaterThanOrEqualTo(Date value) {
            addCriterion("UPLOAD >=", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadLessThan(Date value) {
            addCriterion("UPLOAD <", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadLessThanOrEqualTo(Date value) {
            addCriterion("UPLOAD <=", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadIn(List<Date> values) {
            addCriterion("UPLOAD in", values, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotIn(List<Date> values) {
            addCriterion("UPLOAD not in", values, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadBetween(Date value1, Date value2) {
            addCriterion("UPLOAD between", value1, value2, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotBetween(Date value1, Date value2) {
            addCriterion("UPLOAD not between", value1, value2, "upload");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("FILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("FILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("FILE_TYPE =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("FILE_TYPE <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("FILE_TYPE >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("FILE_TYPE <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("FILE_TYPE like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("FILE_TYPE not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("FILE_TYPE in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("FILE_TYPE not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("FILE_TYPE between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("FILE_TYPE not between", value1, value2, "fileType");
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