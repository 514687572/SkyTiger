package com.skytiger.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BSysTaskExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BSysTaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("sysTask.task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("sysTask.task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("sysTask.task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("sysTask.task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("sysTask.task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("sysTask.task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("sysTask.task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("sysTask.task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("sysTask.task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("sysTask.task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("sysTask.task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("sysTask.task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("sysTask.task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("sysTask.task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIsNull() {
            addCriterion("sysTask.task_url is null");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIsNotNull() {
            addCriterion("sysTask.task_url is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUrlEqualTo(String value) {
            addCriterion("sysTask.task_url =", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotEqualTo(String value) {
            addCriterion("sysTask.task_url <>", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlGreaterThan(String value) {
            addCriterion("sysTask.task_url >", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sysTask.task_url >=", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLessThan(String value) {
            addCriterion("sysTask.task_url <", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLessThanOrEqualTo(String value) {
            addCriterion("sysTask.task_url <=", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLike(String value) {
            addCriterion("sysTask.task_url like", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotLike(String value) {
            addCriterion("sysTask.task_url not like", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIn(List<String> values) {
            addCriterion("sysTask.task_url in", values, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotIn(List<String> values) {
            addCriterion("sysTask.task_url not in", values, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlBetween(String value1, String value2) {
            addCriterion("sysTask.task_url between", value1, value2, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotBetween(String value1, String value2) {
            addCriterion("sysTask.task_url not between", value1, value2, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskCountIsNull() {
            addCriterion("sysTask.task_count is null");
            return (Criteria) this;
        }

        public Criteria andTaskCountIsNotNull() {
            addCriterion("sysTask.task_count is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCountEqualTo(Integer value) {
            addCriterion("sysTask.task_count =", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotEqualTo(Integer value) {
            addCriterion("sysTask.task_count <>", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountGreaterThan(Integer value) {
            addCriterion("sysTask.task_count >", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysTask.task_count >=", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountLessThan(Integer value) {
            addCriterion("sysTask.task_count <", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountLessThanOrEqualTo(Integer value) {
            addCriterion("sysTask.task_count <=", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountIn(List<Integer> values) {
            addCriterion("sysTask.task_count in", values, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotIn(List<Integer> values) {
            addCriterion("sysTask.task_count not in", values, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountBetween(Integer value1, Integer value2) {
            addCriterion("sysTask.task_count between", value1, value2, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sysTask.task_count not between", value1, value2, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("sysTask.task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("sysTask.task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(String value) {
            addCriterion("sysTask.task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(String value) {
            addCriterion("sysTask.task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(String value) {
            addCriterion("sysTask.task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sysTask.task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(String value) {
            addCriterion("sysTask.task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(String value) {
            addCriterion("sysTask.task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLike(String value) {
            addCriterion("sysTask.task_status like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotLike(String value) {
            addCriterion("sysTask.task_status not like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<String> values) {
            addCriterion("sysTask.task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<String> values) {
            addCriterion("sysTask.task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(String value1, String value2) {
            addCriterion("sysTask.task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(String value1, String value2) {
            addCriterion("sysTask.task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskTimeIsNull() {
            addCriterion("sysTask.task_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskTimeIsNotNull() {
            addCriterion("sysTask.task_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTimeEqualTo(Date value) {
            addCriterion("sysTask.task_time =", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeNotEqualTo(Date value) {
            addCriterion("sysTask.task_time <>", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeGreaterThan(Date value) {
            addCriterion("sysTask.task_time >", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sysTask.task_time >=", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeLessThan(Date value) {
            addCriterion("sysTask.task_time <", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeLessThanOrEqualTo(Date value) {
            addCriterion("sysTask.task_time <=", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeIn(List<Date> values) {
            addCriterion("sysTask.task_time in", values, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeNotIn(List<Date> values) {
            addCriterion("sysTask.task_time not in", values, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeBetween(Date value1, Date value2) {
            addCriterion("sysTask.task_time between", value1, value2, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeNotBetween(Date value1, Date value2) {
            addCriterion("sysTask.task_time not between", value1, value2, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameIsNull() {
            addCriterion("sysTask.task_business_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameIsNotNull() {
            addCriterion("sysTask.task_business_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameEqualTo(String value) {
            addCriterion("sysTask.task_business_name =", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameNotEqualTo(String value) {
            addCriterion("sysTask.task_business_name <>", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameGreaterThan(String value) {
            addCriterion("sysTask.task_business_name >", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("sysTask.task_business_name >=", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameLessThan(String value) {
            addCriterion("sysTask.task_business_name <", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("sysTask.task_business_name <=", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameLike(String value) {
            addCriterion("sysTask.task_business_name like", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameNotLike(String value) {
            addCriterion("sysTask.task_business_name not like", value, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameIn(List<String> values) {
            addCriterion("sysTask.task_business_name in", values, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameNotIn(List<String> values) {
            addCriterion("sysTask.task_business_name not in", values, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameBetween(String value1, String value2) {
            addCriterion("sysTask.task_business_name between", value1, value2, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andTaskBusinessNameNotBetween(String value1, String value2) {
            addCriterion("sysTask.task_business_name not between", value1, value2, "taskBusinessName");
            return (Criteria) this;
        }

        public Criteria andHostNameIsNull() {
            addCriterion("sysTask.host_name is null");
            return (Criteria) this;
        }

        public Criteria andHostNameIsNotNull() {
            addCriterion("sysTask.host_name is not null");
            return (Criteria) this;
        }

        public Criteria andHostNameEqualTo(String value) {
            addCriterion("sysTask.host_name =", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotEqualTo(String value) {
            addCriterion("sysTask.host_name <>", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameGreaterThan(String value) {
            addCriterion("sysTask.host_name >", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameGreaterThanOrEqualTo(String value) {
            addCriterion("sysTask.host_name >=", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLessThan(String value) {
            addCriterion("sysTask.host_name <", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLessThanOrEqualTo(String value) {
            addCriterion("sysTask.host_name <=", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLike(String value) {
            addCriterion("sysTask.host_name like", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotLike(String value) {
            addCriterion("sysTask.host_name not like", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameIn(List<String> values) {
            addCriterion("sysTask.host_name in", values, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotIn(List<String> values) {
            addCriterion("sysTask.host_name not in", values, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameBetween(String value1, String value2) {
            addCriterion("sysTask.host_name between", value1, value2, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotBetween(String value1, String value2) {
            addCriterion("sysTask.host_name not between", value1, value2, "hostName");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIsNull() {
            addCriterion("sysTask.task_remark is null");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIsNotNull() {
            addCriterion("sysTask.task_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkEqualTo(String value) {
            addCriterion("sysTask.task_remark =", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotEqualTo(String value) {
            addCriterion("sysTask.task_remark <>", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkGreaterThan(String value) {
            addCriterion("sysTask.task_remark >", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sysTask.task_remark >=", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLessThan(String value) {
            addCriterion("sysTask.task_remark <", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLessThanOrEqualTo(String value) {
            addCriterion("sysTask.task_remark <=", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLike(String value) {
            addCriterion("sysTask.task_remark like", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotLike(String value) {
            addCriterion("sysTask.task_remark not like", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIn(List<String> values) {
            addCriterion("sysTask.task_remark in", values, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotIn(List<String> values) {
            addCriterion("sysTask.task_remark not in", values, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkBetween(String value1, String value2) {
            addCriterion("sysTask.task_remark between", value1, value2, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotBetween(String value1, String value2) {
            addCriterion("sysTask.task_remark not between", value1, value2, "taskRemark");
            return (Criteria) this;
        }
        
        public Criteria orTaskStatusEqualTo(String value,String value1) {
            addCriterion(" (sysTask.task_status ="+value+" or sysTask.task_status="+value1+") ");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}