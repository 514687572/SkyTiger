package com.skytiger.net.entity.base;

import java.util.ArrayList;
import java.util.List;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;

public class BSysBusinessExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BSysBusinessExample() {
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

        public Criteria andSbIdIsNull() {
            addCriterion("sysBusiness.sb_id is null");
            return (Criteria) this;
        }

        public Criteria andSbIdIsNotNull() {
            addCriterion("sysBusiness.sb_id is not null");
            return (Criteria) this;
        }

        public Criteria andSbIdEqualTo(String value) {
            addCriterion("sysBusiness.sb_id =", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotEqualTo(String value) {
            addCriterion("sysBusiness.sb_id <>", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdGreaterThan(String value) {
            addCriterion("sysBusiness.sb_id >", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdGreaterThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_id >=", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLessThan(String value) {
            addCriterion("sysBusiness.sb_id <", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLessThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_id <=", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLike(String value) {
            addCriterion("sysBusiness.sb_id like", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotLike(String value) {
            addCriterion("sysBusiness.sb_id not like", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdIn(List<String> values) {
            addCriterion("sysBusiness.sb_id in", values, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotIn(List<String> values) {
            addCriterion("sysBusiness.sb_id not in", values, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_id between", value1, value2, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_id not between", value1, value2, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbNameIsNull() {
            addCriterion("sysBusiness.sb_name is null");
            return (Criteria) this;
        }

        public Criteria andSbNameIsNotNull() {
            addCriterion("sysBusiness.sb_name is not null");
            return (Criteria) this;
        }

        public Criteria andSbNameEqualTo(String value) {
            addCriterion("sysBusiness.sb_name =", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotEqualTo(String value) {
            addCriterion("sysBusiness.sb_name <>", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameGreaterThan(String value) {
            addCriterion("sysBusiness.sb_name >", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameGreaterThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_name >=", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLessThan(String value) {
            addCriterion("sysBusiness.sb_name <", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLessThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_name <=", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLike(String value) {
            addCriterion("sysBusiness.sb_name like", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotLike(String value) {
            addCriterion("sysBusiness.sb_name not like", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameIn(List<String> values) {
            addCriterion("sysBusiness.sb_name in", values, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotIn(List<String> values) {
            addCriterion("sysBusiness.sb_name not in", values, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_name between", value1, value2, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_name not between", value1, value2, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbPasswordIsNull() {
            addCriterion("sysBusiness.sb_password is null");
            return (Criteria) this;
        }

        public Criteria andSbPasswordIsNotNull() {
            addCriterion("sysBusiness.sb_password is not null");
            return (Criteria) this;
        }

        public Criteria andSbPasswordEqualTo(String value) {
            addCriterion("sysBusiness.sb_password =", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordNotEqualTo(String value) {
            addCriterion("sysBusiness.sb_password <>", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordGreaterThan(String value) {
            addCriterion("sysBusiness.sb_password >", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_password >=", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordLessThan(String value) {
            addCriterion("sysBusiness.sb_password <", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordLessThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_password <=", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordLike(String value) {
            addCriterion("sysBusiness.sb_password like", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordNotLike(String value) {
            addCriterion("sysBusiness.sb_password not like", value, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordIn(List<String> values) {
            addCriterion("sysBusiness.sb_password in", values, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordNotIn(List<String> values) {
            addCriterion("sysBusiness.sb_password not in", values, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_password between", value1, value2, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbPasswordNotBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_password not between", value1, value2, "sbPassword");
            return (Criteria) this;
        }

        public Criteria andSbTitleIsNull() {
            addCriterion("sysBusiness.sb_title is null");
            return (Criteria) this;
        }

        public Criteria andSbTitleIsNotNull() {
            addCriterion("sysBusiness.sb_title is not null");
            return (Criteria) this;
        }

        public Criteria andSbTitleEqualTo(String value) {
            addCriterion("sysBusiness.sb_title =", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleNotEqualTo(String value) {
            addCriterion("sysBusiness.sb_title <>", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleGreaterThan(String value) {
            addCriterion("sysBusiness.sb_title >", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleGreaterThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_title >=", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleLessThan(String value) {
            addCriterion("sysBusiness.sb_title <", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleLessThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_title <=", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleLike(String value) {
            addCriterion("sysBusiness.sb_title like", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleNotLike(String value) {
            addCriterion("sysBusiness.sb_title not like", value, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleIn(List<String> values) {
            addCriterion("sysBusiness.sb_title in", values, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleNotIn(List<String> values) {
            addCriterion("sysBusiness.sb_title not in", values, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_title between", value1, value2, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbTitleNotBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_title not between", value1, value2, "sbTitle");
            return (Criteria) this;
        }

        public Criteria andSbCountIsNull() {
            addCriterion("sysBusiness.sb_count is null");
            return (Criteria) this;
        }

        public Criteria andSbCountIsNotNull() {
            addCriterion("sysBusiness.sb_count is not null");
            return (Criteria) this;
        }

        public Criteria andSbCountEqualTo(Integer value) {
            addCriterion("sysBusiness.sb_count =", value, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountNotEqualTo(Integer value) {
            addCriterion("sysBusiness.sb_count <>", value, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountGreaterThan(Integer value) {
            addCriterion("sysBusiness.sb_count >", value, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysBusiness.sb_count >=", value, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountLessThan(Integer value) {
            addCriterion("sysBusiness.sb_count <", value, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountLessThanOrEqualTo(Integer value) {
            addCriterion("sysBusiness.sb_count <=", value, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountIn(List<Integer> values) {
            addCriterion("sysBusiness.sb_count in", values, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountNotIn(List<Integer> values) {
            addCriterion("sysBusiness.sb_count not in", values, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountBetween(Integer value1, Integer value2) {
            addCriterion("sysBusiness.sb_count between", value1, value2, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sysBusiness.sb_count not between", value1, value2, "sbCount");
            return (Criteria) this;
        }

        public Criteria andSbRemarkIsNull() {
            addCriterion("sysBusiness.sb_remark is null");
            return (Criteria) this;
        }

        public Criteria andSbRemarkIsNotNull() {
            addCriterion("sysBusiness.sb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSbRemarkEqualTo(String value) {
            addCriterion("sysBusiness.sb_remark =", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkNotEqualTo(String value) {
            addCriterion("sysBusiness.sb_remark <>", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkGreaterThan(String value) {
            addCriterion("sysBusiness.sb_remark >", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_remark >=", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkLessThan(String value) {
            addCriterion("sysBusiness.sb_remark <", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkLessThanOrEqualTo(String value) {
            addCriterion("sysBusiness.sb_remark <=", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkLike(String value) {
            addCriterion("sysBusiness.sb_remark like", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkNotLike(String value) {
            addCriterion("sysBusiness.sb_remark not like", value, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkIn(List<String> values) {
            addCriterion("sysBusiness.sb_remark in", values, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkNotIn(List<String> values) {
            addCriterion("sysBusiness.sb_remark not in", values, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_remark between", value1, value2, "sbRemark");
            return (Criteria) this;
        }

        public Criteria andSbRemarkNotBetween(String value1, String value2) {
            addCriterion("sysBusiness.sb_remark not between", value1, value2, "sbRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}