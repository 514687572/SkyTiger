package com.skytiger.net.entity.base;

import java.util.ArrayList;
import java.util.List;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;

public class BDictionaryExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BDictionaryExample() {
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

        public Criteria andDicIdIsNull() {
            addCriterion("dictionary.dic_id is null");
            return (Criteria) this;
        }

        public Criteria andDicIdIsNotNull() {
            addCriterion("dictionary.dic_id is not null");
            return (Criteria) this;
        }

        public Criteria andDicIdEqualTo(String value) {
            addCriterion("dictionary.dic_id =", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotEqualTo(String value) {
            addCriterion("dictionary.dic_id <>", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThan(String value) {
            addCriterion("dictionary.dic_id >", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_id >=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThan(String value) {
            addCriterion("dictionary.dic_id <", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_id <=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLike(String value) {
            addCriterion("dictionary.dic_id like", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotLike(String value) {
            addCriterion("dictionary.dic_id not like", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdIn(List<String> values) {
            addCriterion("dictionary.dic_id in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotIn(List<String> values) {
            addCriterion("dictionary.dic_id not in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdBetween(String value1, String value2) {
            addCriterion("dictionary.dic_id between", value1, value2, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotBetween(String value1, String value2) {
            addCriterion("dictionary.dic_id not between", value1, value2, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicKeyIsNull() {
            addCriterion("dictionary.dic_key is null");
            return (Criteria) this;
        }

        public Criteria andDicKeyIsNotNull() {
            addCriterion("dictionary.dic_key is not null");
            return (Criteria) this;
        }

        public Criteria andDicKeyEqualTo(String value) {
            addCriterion("dictionary.dic_key =", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotEqualTo(String value) {
            addCriterion("dictionary.dic_key <>", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThan(String value) {
            addCriterion("dictionary.dic_key >", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_key >=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThan(String value) {
            addCriterion("dictionary.dic_key <", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_key <=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLike(String value) {
            addCriterion("dictionary.dic_key like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotLike(String value) {
            addCriterion("dictionary.dic_key not like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyIn(List<String> values) {
            addCriterion("dictionary.dic_key in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotIn(List<String> values) {
            addCriterion("dictionary.dic_key not in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyBetween(String value1, String value2) {
            addCriterion("dictionary.dic_key between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotBetween(String value1, String value2) {
            addCriterion("dictionary.dic_key not between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNull() {
            addCriterion("dictionary.dic_value is null");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNotNull() {
            addCriterion("dictionary.dic_value is not null");
            return (Criteria) this;
        }

        public Criteria andDicValueEqualTo(String value) {
            addCriterion("dictionary.dic_value =", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotEqualTo(String value) {
            addCriterion("dictionary.dic_value <>", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThan(String value) {
            addCriterion("dictionary.dic_value >", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_value >=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThan(String value) {
            addCriterion("dictionary.dic_value <", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_value <=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLike(String value) {
            addCriterion("dictionary.dic_value like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotLike(String value) {
            addCriterion("dictionary.dic_value not like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueIn(List<String> values) {
            addCriterion("dictionary.dic_value in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotIn(List<String> values) {
            addCriterion("dictionary.dic_value not in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueBetween(String value1, String value2) {
            addCriterion("dictionary.dic_value between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotBetween(String value1, String value2) {
            addCriterion("dictionary.dic_value not between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicTypeIsNull() {
            addCriterion("dictionary.dic_type is null");
            return (Criteria) this;
        }

        public Criteria andDicTypeIsNotNull() {
            addCriterion("dictionary.dic_type is not null");
            return (Criteria) this;
        }

        public Criteria andDicTypeEqualTo(String value) {
            addCriterion("dictionary.dic_type =", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotEqualTo(String value) {
            addCriterion("dictionary.dic_type <>", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeGreaterThan(String value) {
            addCriterion("dictionary.dic_type >", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_type >=", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLessThan(String value) {
            addCriterion("dictionary.dic_type <", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLessThanOrEqualTo(String value) {
            addCriterion("dictionary.dic_type <=", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLike(String value) {
            addCriterion("dictionary.dic_type like", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotLike(String value) {
            addCriterion("dictionary.dic_type not like", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeIn(List<String> values) {
            addCriterion("dictionary.dic_type in", values, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotIn(List<String> values) {
            addCriterion("dictionary.dic_type not in", values, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeBetween(String value1, String value2) {
            addCriterion("dictionary.dic_type between", value1, value2, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotBetween(String value1, String value2) {
            addCriterion("dictionary.dic_type not between", value1, value2, "dicType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("dictionary.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("dictionary.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("dictionary.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("dictionary.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("dictionary.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("dictionary.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("dictionary.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("dictionary.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("dictionary.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("dictionary.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("dictionary.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("dictionary.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("dictionary.remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}