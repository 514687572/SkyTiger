package com.skytiger.net.entity.base;

import java.util.ArrayList;
import java.util.List;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;

public class BAddressInfoExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BAddressInfoExample() {
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

        public Criteria andInfoIdIsNull() {
            addCriterion("addressInfo.info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("addressInfo.info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(String value) {
            addCriterion("addressInfo.info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(String value) {
            addCriterion("addressInfo.info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(String value) {
            addCriterion("addressInfo.info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(String value) {
            addCriterion("addressInfo.info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLike(String value) {
            addCriterion("addressInfo.info_id like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotLike(String value) {
            addCriterion("addressInfo.info_id not like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<String> values) {
            addCriterion("addressInfo.info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<String> values) {
            addCriterion("addressInfo.info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(String value1, String value2) {
            addCriterion("addressInfo.info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(String value1, String value2) {
            addCriterion("addressInfo.info_id not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoNameIsNull() {
            addCriterion("addressInfo.info_name is null");
            return (Criteria) this;
        }

        public Criteria andInfoNameIsNotNull() {
            addCriterion("addressInfo.info_name is not null");
            return (Criteria) this;
        }

        public Criteria andInfoNameEqualTo(String value) {
            addCriterion("addressInfo.info_name =", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotEqualTo(String value) {
            addCriterion("addressInfo.info_name <>", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameGreaterThan(String value) {
            addCriterion("addressInfo.info_name >", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_name >=", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLessThan(String value) {
            addCriterion("addressInfo.info_name <", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_name <=", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLike(String value) {
            addCriterion("addressInfo.info_name like", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotLike(String value) {
            addCriterion("addressInfo.info_name not like", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameIn(List<String> values) {
            addCriterion("addressInfo.info_name in", values, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotIn(List<String> values) {
            addCriterion("addressInfo.info_name not in", values, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameBetween(String value1, String value2) {
            addCriterion("addressInfo.info_name between", value1, value2, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotBetween(String value1, String value2) {
            addCriterion("addressInfo.info_name not between", value1, value2, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneIsNull() {
            addCriterion("addressInfo.info_phone is null");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneIsNotNull() {
            addCriterion("addressInfo.info_phone is not null");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneEqualTo(String value) {
            addCriterion("addressInfo.info_phone =", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneNotEqualTo(String value) {
            addCriterion("addressInfo.info_phone <>", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneGreaterThan(String value) {
            addCriterion("addressInfo.info_phone >", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_phone >=", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneLessThan(String value) {
            addCriterion("addressInfo.info_phone <", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_phone <=", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneLike(String value) {
            addCriterion("addressInfo.info_phone like", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneNotLike(String value) {
            addCriterion("addressInfo.info_phone not like", value, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneIn(List<String> values) {
            addCriterion("addressInfo.info_phone in", values, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneNotIn(List<String> values) {
            addCriterion("addressInfo.info_phone not in", values, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneBetween(String value1, String value2) {
            addCriterion("addressInfo.info_phone between", value1, value2, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoPhoneNotBetween(String value1, String value2) {
            addCriterion("addressInfo.info_phone not between", value1, value2, "infoPhone");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceIsNull() {
            addCriterion("addressInfo.info_province is null");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceIsNotNull() {
            addCriterion("addressInfo.info_province is not null");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceEqualTo(String value) {
            addCriterion("addressInfo.info_province =", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceNotEqualTo(String value) {
            addCriterion("addressInfo.info_province <>", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceGreaterThan(String value) {
            addCriterion("addressInfo.info_province >", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_province >=", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceLessThan(String value) {
            addCriterion("addressInfo.info_province <", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_province <=", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceLike(String value) {
            addCriterion("addressInfo.info_province like", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceNotLike(String value) {
            addCriterion("addressInfo.info_province not like", value, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceIn(List<String> values) {
            addCriterion("addressInfo.info_province in", values, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceNotIn(List<String> values) {
            addCriterion("addressInfo.info_province not in", values, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceBetween(String value1, String value2) {
            addCriterion("addressInfo.info_province between", value1, value2, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoProvinceNotBetween(String value1, String value2) {
            addCriterion("addressInfo.info_province not between", value1, value2, "infoProvince");
            return (Criteria) this;
        }

        public Criteria andInfoCityIsNull() {
            addCriterion("addressInfo.info_city is null");
            return (Criteria) this;
        }

        public Criteria andInfoCityIsNotNull() {
            addCriterion("addressInfo.info_city is not null");
            return (Criteria) this;
        }

        public Criteria andInfoCityEqualTo(String value) {
            addCriterion("addressInfo.info_city =", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityNotEqualTo(String value) {
            addCriterion("addressInfo.info_city <>", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityGreaterThan(String value) {
            addCriterion("addressInfo.info_city >", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_city >=", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityLessThan(String value) {
            addCriterion("addressInfo.info_city <", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_city <=", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityLike(String value) {
            addCriterion("addressInfo.info_city like", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityNotLike(String value) {
            addCriterion("addressInfo.info_city not like", value, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityIn(List<String> values) {
            addCriterion("addressInfo.info_city in", values, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityNotIn(List<String> values) {
            addCriterion("addressInfo.info_city not in", values, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityBetween(String value1, String value2) {
            addCriterion("addressInfo.info_city between", value1, value2, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoCityNotBetween(String value1, String value2) {
            addCriterion("addressInfo.info_city not between", value1, value2, "infoCity");
            return (Criteria) this;
        }

        public Criteria andInfoAreaIsNull() {
            addCriterion("addressInfo.info_area is null");
            return (Criteria) this;
        }

        public Criteria andInfoAreaIsNotNull() {
            addCriterion("addressInfo.info_area is not null");
            return (Criteria) this;
        }

        public Criteria andInfoAreaEqualTo(String value) {
            addCriterion("addressInfo.info_area =", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaNotEqualTo(String value) {
            addCriterion("addressInfo.info_area <>", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaGreaterThan(String value) {
            addCriterion("addressInfo.info_area >", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_area >=", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaLessThan(String value) {
            addCriterion("addressInfo.info_area <", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_area <=", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaLike(String value) {
            addCriterion("addressInfo.info_area like", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaNotLike(String value) {
            addCriterion("addressInfo.info_area not like", value, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaIn(List<String> values) {
            addCriterion("addressInfo.info_area in", values, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaNotIn(List<String> values) {
            addCriterion("addressInfo.info_area not in", values, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaBetween(String value1, String value2) {
            addCriterion("addressInfo.info_area between", value1, value2, "infoArea");
            return (Criteria) this;
        }

        public Criteria andInfoAreaNotBetween(String value1, String value2) {
            addCriterion("addressInfo.info_area not between", value1, value2, "infoArea");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsIsNull() {
            addCriterion("addressInfo.address_details is null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsIsNotNull() {
            addCriterion("addressInfo.address_details is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsEqualTo(String value) {
            addCriterion("addressInfo.address_details =", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsNotEqualTo(String value) {
            addCriterion("addressInfo.address_details <>", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsGreaterThan(String value) {
            addCriterion("addressInfo.address_details >", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.address_details >=", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsLessThan(String value) {
            addCriterion("addressInfo.address_details <", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.address_details <=", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsLike(String value) {
            addCriterion("addressInfo.address_details like", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsNotLike(String value) {
            addCriterion("addressInfo.address_details not like", value, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsIn(List<String> values) {
            addCriterion("addressInfo.address_details in", values, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsNotIn(List<String> values) {
            addCriterion("addressInfo.address_details not in", values, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsBetween(String value1, String value2) {
            addCriterion("addressInfo.address_details between", value1, value2, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andAddressDetailsNotBetween(String value1, String value2) {
            addCriterion("addressInfo.address_details not between", value1, value2, "addressDetails");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkIsNull() {
            addCriterion("addressInfo.info_remark is null");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkIsNotNull() {
            addCriterion("addressInfo.info_remark is not null");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkEqualTo(String value) {
            addCriterion("addressInfo.info_remark =", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotEqualTo(String value) {
            addCriterion("addressInfo.info_remark <>", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkGreaterThan(String value) {
            addCriterion("addressInfo.info_remark >", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_remark >=", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkLessThan(String value) {
            addCriterion("addressInfo.info_remark <", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkLessThanOrEqualTo(String value) {
            addCriterion("addressInfo.info_remark <=", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkLike(String value) {
            addCriterion("addressInfo.info_remark like", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotLike(String value) {
            addCriterion("addressInfo.info_remark not like", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkIn(List<String> values) {
            addCriterion("addressInfo.info_remark in", values, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotIn(List<String> values) {
            addCriterion("addressInfo.info_remark not in", values, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkBetween(String value1, String value2) {
            addCriterion("addressInfo.info_remark between", value1, value2, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotBetween(String value1, String value2) {
            addCriterion("addressInfo.info_remark not between", value1, value2, "infoRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}