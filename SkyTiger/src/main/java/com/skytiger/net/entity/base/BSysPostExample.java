package com.skytiger.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BSysPostExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BSysPostExample() {
        oredCriteria = new ArrayList<Criteria>();
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
        super.clear();
        oredCriteria.clear();
    }

    protected abstract static class GeneratedCriteria extends BaseCriteria {

        public Criteria andPostIdIsNull() {
            addCriterion("sysPost.post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("sysPost.post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(String value) {
            addCriterion("sysPost.post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(String value) {
            addCriterion("sysPost.post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(String value) {
            addCriterion("sysPost.post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("sysPost.post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(String value) {
            addCriterion("sysPost.post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(String value) {
            addCriterion("sysPost.post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLike(String value) {
            addCriterion("sysPost.post_id like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotLike(String value) {
            addCriterion("sysPost.post_id not like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<String> values) {
            addCriterion("sysPost.post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<String> values) {
            addCriterion("sysPost.post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(String value1, String value2) {
            addCriterion("sysPost.post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(String value1, String value2) {
            addCriterion("sysPost.post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostNumIsNull() {
            addCriterion("sysPost.post_num is null");
            return (Criteria) this;
        }

        public Criteria andPostNumIsNotNull() {
            addCriterion("sysPost.post_num is not null");
            return (Criteria) this;
        }

        public Criteria andPostNumEqualTo(String value) {
            addCriterion("sysPost.post_num =", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumNotEqualTo(String value) {
            addCriterion("sysPost.post_num <>", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumGreaterThan(String value) {
            addCriterion("sysPost.post_num >", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumGreaterThanOrEqualTo(String value) {
            addCriterion("sysPost.post_num >=", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumLessThan(String value) {
            addCriterion("sysPost.post_num <", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumLessThanOrEqualTo(String value) {
            addCriterion("sysPost.post_num <=", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumLike(String value) {
            addCriterion("sysPost.post_num like", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumNotLike(String value) {
            addCriterion("sysPost.post_num not like", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumIn(List<String> values) {
            addCriterion("sysPost.post_num in", values, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumNotIn(List<String> values) {
            addCriterion("sysPost.post_num not in", values, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumBetween(String value1, String value2) {
            addCriterion("sysPost.post_num between", value1, value2, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumNotBetween(String value1, String value2) {
            addCriterion("sysPost.post_num not between", value1, value2, "postNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("sysPost.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("sysPost.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("sysPost.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("sysPost.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("sysPost.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sysPost.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("sysPost.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sysPost.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("sysPost.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("sysPost.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("sysPost.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sysPost.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPostRemarkIsNull() {
            addCriterion("sysPost.post_remark is null");
            return (Criteria) this;
        }

        public Criteria andPostRemarkIsNotNull() {
            addCriterion("sysPost.post_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPostRemarkEqualTo(String value) {
            addCriterion("sysPost.post_remark =", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkNotEqualTo(String value) {
            addCriterion("sysPost.post_remark <>", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkGreaterThan(String value) {
            addCriterion("sysPost.post_remark >", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sysPost.post_remark >=", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkLessThan(String value) {
            addCriterion("sysPost.post_remark <", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkLessThanOrEqualTo(String value) {
            addCriterion("sysPost.post_remark <=", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkLike(String value) {
            addCriterion("sysPost.post_remark like", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkNotLike(String value) {
            addCriterion("sysPost.post_remark not like", value, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkIn(List<String> values) {
            addCriterion("sysPost.post_remark in", values, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkNotIn(List<String> values) {
            addCriterion("sysPost.post_remark not in", values, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkBetween(String value1, String value2) {
            addCriterion("sysPost.post_remark between", value1, value2, "postRemark");
            return (Criteria) this;
        }

        public Criteria andPostRemarkNotBetween(String value1, String value2) {
            addCriterion("sysPost.post_remark not between", value1, value2, "postRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}