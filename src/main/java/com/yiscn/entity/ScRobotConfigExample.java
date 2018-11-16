package com.yiscn.entity;

import java.util.ArrayList;
import java.util.List;

public class ScRobotConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScRobotConfigExample() {
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

        public Criteria andRobotnameIsNull() {
            addCriterion("robotName is null");
            return (Criteria) this;
        }

        public Criteria andRobotnameIsNotNull() {
            addCriterion("robotName is not null");
            return (Criteria) this;
        }

        public Criteria andRobotnameEqualTo(String value) {
            addCriterion("robotName =", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameNotEqualTo(String value) {
            addCriterion("robotName <>", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameGreaterThan(String value) {
            addCriterion("robotName >", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameGreaterThanOrEqualTo(String value) {
            addCriterion("robotName >=", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameLessThan(String value) {
            addCriterion("robotName <", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameLessThanOrEqualTo(String value) {
            addCriterion("robotName <=", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameLike(String value) {
            addCriterion("robotName like", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameNotLike(String value) {
            addCriterion("robotName not like", value, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameIn(List<String> values) {
            addCriterion("robotName in", values, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameNotIn(List<String> values) {
            addCriterion("robotName not in", values, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameBetween(String value1, String value2) {
            addCriterion("robotName between", value1, value2, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotnameNotBetween(String value1, String value2) {
            addCriterion("robotName not between", value1, value2, "robotname");
            return (Criteria) this;
        }

        public Criteria andRobotheadIsNull() {
            addCriterion("robotHead is null");
            return (Criteria) this;
        }

        public Criteria andRobotheadIsNotNull() {
            addCriterion("robotHead is not null");
            return (Criteria) this;
        }

        public Criteria andRobotheadEqualTo(String value) {
            addCriterion("robotHead =", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadNotEqualTo(String value) {
            addCriterion("robotHead <>", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadGreaterThan(String value) {
            addCriterion("robotHead >", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadGreaterThanOrEqualTo(String value) {
            addCriterion("robotHead >=", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadLessThan(String value) {
            addCriterion("robotHead <", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadLessThanOrEqualTo(String value) {
            addCriterion("robotHead <=", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadLike(String value) {
            addCriterion("robotHead like", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadNotLike(String value) {
            addCriterion("robotHead not like", value, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadIn(List<String> values) {
            addCriterion("robotHead in", values, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadNotIn(List<String> values) {
            addCriterion("robotHead not in", values, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadBetween(String value1, String value2) {
            addCriterion("robotHead between", value1, value2, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotheadNotBetween(String value1, String value2) {
            addCriterion("robotHead not between", value1, value2, "robothead");
            return (Criteria) this;
        }

        public Criteria andRobotareaIsNull() {
            addCriterion("robotArea is null");
            return (Criteria) this;
        }

        public Criteria andRobotareaIsNotNull() {
            addCriterion("robotArea is not null");
            return (Criteria) this;
        }

        public Criteria andRobotareaEqualTo(Integer value) {
            addCriterion("robotArea =", value, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaNotEqualTo(Integer value) {
            addCriterion("robotArea <>", value, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaGreaterThan(Integer value) {
            addCriterion("robotArea >", value, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("robotArea >=", value, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaLessThan(Integer value) {
            addCriterion("robotArea <", value, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaLessThanOrEqualTo(Integer value) {
            addCriterion("robotArea <=", value, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaIn(List<Integer> values) {
            addCriterion("robotArea in", values, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaNotIn(List<Integer> values) {
            addCriterion("robotArea not in", values, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaBetween(Integer value1, Integer value2) {
            addCriterion("robotArea between", value1, value2, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotareaNotBetween(Integer value1, Integer value2) {
            addCriterion("robotArea not between", value1, value2, "robotarea");
            return (Criteria) this;
        }

        public Criteria andRobotrateIsNull() {
            addCriterion("robotRate is null");
            return (Criteria) this;
        }

        public Criteria andRobotrateIsNotNull() {
            addCriterion("robotRate is not null");
            return (Criteria) this;
        }

        public Criteria andRobotrateEqualTo(Integer value) {
            addCriterion("robotRate =", value, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateNotEqualTo(Integer value) {
            addCriterion("robotRate <>", value, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateGreaterThan(Integer value) {
            addCriterion("robotRate >", value, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("robotRate >=", value, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateLessThan(Integer value) {
            addCriterion("robotRate <", value, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateLessThanOrEqualTo(Integer value) {
            addCriterion("robotRate <=", value, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateIn(List<Integer> values) {
            addCriterion("robotRate in", values, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateNotIn(List<Integer> values) {
            addCriterion("robotRate not in", values, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateBetween(Integer value1, Integer value2) {
            addCriterion("robotRate between", value1, value2, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotrateNotBetween(Integer value1, Integer value2) {
            addCriterion("robotRate not between", value1, value2, "robotrate");
            return (Criteria) this;
        }

        public Criteria andRobotisuseIsNull() {
            addCriterion("robotIsUse is null");
            return (Criteria) this;
        }

        public Criteria andRobotisuseIsNotNull() {
            addCriterion("robotIsUse is not null");
            return (Criteria) this;
        }

        public Criteria andRobotisuseEqualTo(Boolean value) {
            addCriterion("robotIsUse =", value, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseNotEqualTo(Boolean value) {
            addCriterion("robotIsUse <>", value, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseGreaterThan(Boolean value) {
            addCriterion("robotIsUse >", value, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("robotIsUse >=", value, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseLessThan(Boolean value) {
            addCriterion("robotIsUse <", value, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseLessThanOrEqualTo(Boolean value) {
            addCriterion("robotIsUse <=", value, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseIn(List<Boolean> values) {
            addCriterion("robotIsUse in", values, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseNotIn(List<Boolean> values) {
            addCriterion("robotIsUse not in", values, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseBetween(Boolean value1, Boolean value2) {
            addCriterion("robotIsUse between", value1, value2, "robotisuse");
            return (Criteria) this;
        }

        public Criteria andRobotisuseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("robotIsUse not between", value1, value2, "robotisuse");
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