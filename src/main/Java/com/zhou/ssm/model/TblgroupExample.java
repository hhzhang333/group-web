package com.zhou.ssm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TblgroupExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public TblgroupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGdateIsNull() {
            addCriterion("gDate is null");
            return (Criteria) this;
        }

        public Criteria andGdateIsNotNull() {
            addCriterion("gDate is not null");
            return (Criteria) this;
        }

        public Criteria andGdateEqualTo(Date value) {
            addCriterionForJDBCDate("gDate =", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("gDate <>", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThan(Date value) {
            addCriterionForJDBCDate("gDate >", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gDate >=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThan(Date value) {
            addCriterionForJDBCDate("gDate <", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gDate <=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateIn(List<Date> values) {
            addCriterionForJDBCDate("gDate in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("gDate not in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gDate between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gDate not between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGspaceIsNull() {
            addCriterion("gSpace is null");
            return (Criteria) this;
        }

        public Criteria andGspaceIsNotNull() {
            addCriterion("gSpace is not null");
            return (Criteria) this;
        }

        public Criteria andGspaceEqualTo(String value) {
            addCriterion("gSpace =", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceNotEqualTo(String value) {
            addCriterion("gSpace <>", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceGreaterThan(String value) {
            addCriterion("gSpace >", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceGreaterThanOrEqualTo(String value) {
            addCriterion("gSpace >=", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceLessThan(String value) {
            addCriterion("gSpace <", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceLessThanOrEqualTo(String value) {
            addCriterion("gSpace <=", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceLike(String value) {
            addCriterion("gSpace like", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceNotLike(String value) {
            addCriterion("gSpace not like", value, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceIn(List<String> values) {
            addCriterion("gSpace in", values, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceNotIn(List<String> values) {
            addCriterion("gSpace not in", values, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceBetween(String value1, String value2) {
            addCriterion("gSpace between", value1, value2, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspaceNotBetween(String value1, String value2) {
            addCriterion("gSpace not between", value1, value2, "gspace");
            return (Criteria) this;
        }

        public Criteria andGspeakerIsNull() {
            addCriterion("gSpeaker is null");
            return (Criteria) this;
        }

        public Criteria andGspeakerIsNotNull() {
            addCriterion("gSpeaker is not null");
            return (Criteria) this;
        }

        public Criteria andGspeakerEqualTo(String value) {
            addCriterion("gSpeaker =", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerNotEqualTo(String value) {
            addCriterion("gSpeaker <>", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerGreaterThan(String value) {
            addCriterion("gSpeaker >", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerGreaterThanOrEqualTo(String value) {
            addCriterion("gSpeaker >=", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerLessThan(String value) {
            addCriterion("gSpeaker <", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerLessThanOrEqualTo(String value) {
            addCriterion("gSpeaker <=", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerLike(String value) {
            addCriterion("gSpeaker like", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerNotLike(String value) {
            addCriterion("gSpeaker not like", value, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerIn(List<String> values) {
            addCriterion("gSpeaker in", values, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerNotIn(List<String> values) {
            addCriterion("gSpeaker not in", values, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerBetween(String value1, String value2) {
            addCriterion("gSpeaker between", value1, value2, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGspeakerNotBetween(String value1, String value2) {
            addCriterion("gSpeaker not between", value1, value2, "gspeaker");
            return (Criteria) this;
        }

        public Criteria andGlistenerIsNull() {
            addCriterion("gListener is null");
            return (Criteria) this;
        }

        public Criteria andGlistenerIsNotNull() {
            addCriterion("gListener is not null");
            return (Criteria) this;
        }

        public Criteria andGlistenerEqualTo(String value) {
            addCriterion("gListener =", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerNotEqualTo(String value) {
            addCriterion("gListener <>", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerGreaterThan(String value) {
            addCriterion("gListener >", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerGreaterThanOrEqualTo(String value) {
            addCriterion("gListener >=", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerLessThan(String value) {
            addCriterion("gListener <", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerLessThanOrEqualTo(String value) {
            addCriterion("gListener <=", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerLike(String value) {
            addCriterion("gListener like", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerNotLike(String value) {
            addCriterion("gListener not like", value, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerIn(List<String> values) {
            addCriterion("gListener in", values, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerNotIn(List<String> values) {
            addCriterion("gListener not in", values, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerBetween(String value1, String value2) {
            addCriterion("gListener between", value1, value2, "glistener");
            return (Criteria) this;
        }

        public Criteria andGlistenerNotBetween(String value1, String value2) {
            addCriterion("gListener not between", value1, value2, "glistener");
            return (Criteria) this;
        }

        public Criteria andGtopicIsNull() {
            addCriterion("gTopic is null");
            return (Criteria) this;
        }

        public Criteria andGtopicIsNotNull() {
            addCriterion("gTopic is not null");
            return (Criteria) this;
        }

        public Criteria andGtopicEqualTo(String value) {
            addCriterion("gTopic =", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicNotEqualTo(String value) {
            addCriterion("gTopic <>", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicGreaterThan(String value) {
            addCriterion("gTopic >", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicGreaterThanOrEqualTo(String value) {
            addCriterion("gTopic >=", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicLessThan(String value) {
            addCriterion("gTopic <", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicLessThanOrEqualTo(String value) {
            addCriterion("gTopic <=", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicLike(String value) {
            addCriterion("gTopic like", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicNotLike(String value) {
            addCriterion("gTopic not like", value, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicIn(List<String> values) {
            addCriterion("gTopic in", values, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicNotIn(List<String> values) {
            addCriterion("gTopic not in", values, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicBetween(String value1, String value2) {
            addCriterion("gTopic between", value1, value2, "gtopic");
            return (Criteria) this;
        }

        public Criteria andGtopicNotBetween(String value1, String value2) {
            addCriterion("gTopic not between", value1, value2, "gtopic");
            return (Criteria) this;
        }

        public Criteria andPptIsNull() {
            addCriterion("ppt is null");
            return (Criteria) this;
        }

        public Criteria andPptIsNotNull() {
            addCriterion("ppt is not null");
            return (Criteria) this;
        }

        public Criteria andPptEqualTo(String value) {
            addCriterion("ppt =", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptNotEqualTo(String value) {
            addCriterion("ppt <>", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptGreaterThan(String value) {
            addCriterion("ppt >", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptGreaterThanOrEqualTo(String value) {
            addCriterion("ppt >=", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptLessThan(String value) {
            addCriterion("ppt <", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptLessThanOrEqualTo(String value) {
            addCriterion("ppt <=", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptLike(String value) {
            addCriterion("ppt like", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptNotLike(String value) {
            addCriterion("ppt not like", value, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptIn(List<String> values) {
            addCriterion("ppt in", values, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptNotIn(List<String> values) {
            addCriterion("ppt not in", values, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptBetween(String value1, String value2) {
            addCriterion("ppt between", value1, value2, "ppt");
            return (Criteria) this;
        }

        public Criteria andPptNotBetween(String value1, String value2) {
            addCriterion("ppt not between", value1, value2, "ppt");
            return (Criteria) this;
        }

        public Criteria andPdfIsNull() {
            addCriterion("pdf is null");
            return (Criteria) this;
        }

        public Criteria andPdfIsNotNull() {
            addCriterion("pdf is not null");
            return (Criteria) this;
        }

        public Criteria andPdfEqualTo(String value) {
            addCriterion("pdf =", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfNotEqualTo(String value) {
            addCriterion("pdf <>", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfGreaterThan(String value) {
            addCriterion("pdf >", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfGreaterThanOrEqualTo(String value) {
            addCriterion("pdf >=", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfLessThan(String value) {
            addCriterion("pdf <", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfLessThanOrEqualTo(String value) {
            addCriterion("pdf <=", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfLike(String value) {
            addCriterion("pdf like", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfNotLike(String value) {
            addCriterion("pdf not like", value, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfIn(List<String> values) {
            addCriterion("pdf in", values, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfNotIn(List<String> values) {
            addCriterion("pdf not in", values, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfBetween(String value1, String value2) {
            addCriterion("pdf between", value1, value2, "pdf");
            return (Criteria) this;
        }

        public Criteria andPdfNotBetween(String value1, String value2) {
            addCriterion("pdf not between", value1, value2, "pdf");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tblgroup
     *
     * @mbggenerated do_not_delete_during_merge Tue Apr 18 14:54:15 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
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