package com.yiscn.entity;

import java.util.ArrayList;
import java.util.List;

public class ScExperienceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScExperienceExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMouthIsNull() {
            addCriterion("mouth is null");
            return (Criteria) this;
        }

        public Criteria andMouthIsNotNull() {
            addCriterion("mouth is not null");
            return (Criteria) this;
        }

        public Criteria andMouthEqualTo(Integer value) {
            addCriterion("mouth =", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthNotEqualTo(Integer value) {
            addCriterion("mouth <>", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthGreaterThan(Integer value) {
            addCriterion("mouth >", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthGreaterThanOrEqualTo(Integer value) {
            addCriterion("mouth >=", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthLessThan(Integer value) {
            addCriterion("mouth <", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthLessThanOrEqualTo(Integer value) {
            addCriterion("mouth <=", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthIn(List<Integer> values) {
            addCriterion("mouth in", values, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthNotIn(List<Integer> values) {
            addCriterion("mouth not in", values, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthBetween(Integer value1, Integer value2) {
            addCriterion("mouth between", value1, value2, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthNotBetween(Integer value1, Integer value2) {
            addCriterion("mouth not between", value1, value2, "mouth");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andParagraphIsNull() {
            addCriterion("paragraph is null");
            return (Criteria) this;
        }

        public Criteria andParagraphIsNotNull() {
            addCriterion("paragraph is not null");
            return (Criteria) this;
        }

        public Criteria andParagraphEqualTo(Integer value) {
            addCriterion("paragraph =", value, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphNotEqualTo(Integer value) {
            addCriterion("paragraph <>", value, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphGreaterThan(Integer value) {
            addCriterion("paragraph >", value, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphGreaterThanOrEqualTo(Integer value) {
            addCriterion("paragraph >=", value, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphLessThan(Integer value) {
            addCriterion("paragraph <", value, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphLessThanOrEqualTo(Integer value) {
            addCriterion("paragraph <=", value, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphIn(List<Integer> values) {
            addCriterion("paragraph in", values, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphNotIn(List<Integer> values) {
            addCriterion("paragraph not in", values, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphBetween(Integer value1, Integer value2) {
            addCriterion("paragraph between", value1, value2, "paragraph");
            return (Criteria) this;
        }

        public Criteria andParagraphNotBetween(Integer value1, Integer value2) {
            addCriterion("paragraph not between", value1, value2, "paragraph");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryIsNull() {
            addCriterion("heightVictory is null");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryIsNotNull() {
            addCriterion("heightVictory is not null");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryEqualTo(Integer value) {
            addCriterion("heightVictory =", value, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryNotEqualTo(Integer value) {
            addCriterion("heightVictory <>", value, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryGreaterThan(Integer value) {
            addCriterion("heightVictory >", value, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("heightVictory >=", value, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryLessThan(Integer value) {
            addCriterion("heightVictory <", value, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryLessThanOrEqualTo(Integer value) {
            addCriterion("heightVictory <=", value, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryIn(List<Integer> values) {
            addCriterion("heightVictory in", values, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryNotIn(List<Integer> values) {
            addCriterion("heightVictory not in", values, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryBetween(Integer value1, Integer value2) {
            addCriterion("heightVictory between", value1, value2, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andHeightvictoryNotBetween(Integer value1, Integer value2) {
            addCriterion("heightVictory not between", value1, value2, "heightvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryIsNull() {
            addCriterion("nowVictory is null");
            return (Criteria) this;
        }

        public Criteria andNowvictoryIsNotNull() {
            addCriterion("nowVictory is not null");
            return (Criteria) this;
        }

        public Criteria andNowvictoryEqualTo(Integer value) {
            addCriterion("nowVictory =", value, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryNotEqualTo(Integer value) {
            addCriterion("nowVictory <>", value, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryGreaterThan(Integer value) {
            addCriterion("nowVictory >", value, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("nowVictory >=", value, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryLessThan(Integer value) {
            addCriterion("nowVictory <", value, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryLessThanOrEqualTo(Integer value) {
            addCriterion("nowVictory <=", value, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryIn(List<Integer> values) {
            addCriterion("nowVictory in", values, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryNotIn(List<Integer> values) {
            addCriterion("nowVictory not in", values, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryBetween(Integer value1, Integer value2) {
            addCriterion("nowVictory between", value1, value2, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andNowvictoryNotBetween(Integer value1, Integer value2) {
            addCriterion("nowVictory not between", value1, value2, "nowvictory");
            return (Criteria) this;
        }

        public Criteria andAllfieldIsNull() {
            addCriterion("allField is null");
            return (Criteria) this;
        }

        public Criteria andAllfieldIsNotNull() {
            addCriterion("allField is not null");
            return (Criteria) this;
        }

        public Criteria andAllfieldEqualTo(Integer value) {
            addCriterion("allField =", value, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldNotEqualTo(Integer value) {
            addCriterion("allField <>", value, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldGreaterThan(Integer value) {
            addCriterion("allField >", value, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldGreaterThanOrEqualTo(Integer value) {
            addCriterion("allField >=", value, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldLessThan(Integer value) {
            addCriterion("allField <", value, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldLessThanOrEqualTo(Integer value) {
            addCriterion("allField <=", value, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldIn(List<Integer> values) {
            addCriterion("allField in", values, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldNotIn(List<Integer> values) {
            addCriterion("allField not in", values, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldBetween(Integer value1, Integer value2) {
            addCriterion("allField between", value1, value2, "allfield");
            return (Criteria) this;
        }

        public Criteria andAllfieldNotBetween(Integer value1, Integer value2) {
            addCriterion("allField not between", value1, value2, "allfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldIsNull() {
            addCriterion("winField is null");
            return (Criteria) this;
        }

        public Criteria andWinfieldIsNotNull() {
            addCriterion("winField is not null");
            return (Criteria) this;
        }

        public Criteria andWinfieldEqualTo(Integer value) {
            addCriterion("winField =", value, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldNotEqualTo(Integer value) {
            addCriterion("winField <>", value, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldGreaterThan(Integer value) {
            addCriterion("winField >", value, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldGreaterThanOrEqualTo(Integer value) {
            addCriterion("winField >=", value, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldLessThan(Integer value) {
            addCriterion("winField <", value, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldLessThanOrEqualTo(Integer value) {
            addCriterion("winField <=", value, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldIn(List<Integer> values) {
            addCriterion("winField in", values, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldNotIn(List<Integer> values) {
            addCriterion("winField not in", values, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldBetween(Integer value1, Integer value2) {
            addCriterion("winField between", value1, value2, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinfieldNotBetween(Integer value1, Integer value2) {
            addCriterion("winField not between", value1, value2, "winfield");
            return (Criteria) this;
        }

        public Criteria andWinrateIsNull() {
            addCriterion("winRate is null");
            return (Criteria) this;
        }

        public Criteria andWinrateIsNotNull() {
            addCriterion("winRate is not null");
            return (Criteria) this;
        }

        public Criteria andWinrateEqualTo(String value) {
            addCriterion("winRate =", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateNotEqualTo(String value) {
            addCriterion("winRate <>", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateGreaterThan(String value) {
            addCriterion("winRate >", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateGreaterThanOrEqualTo(String value) {
            addCriterion("winRate >=", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateLessThan(String value) {
            addCriterion("winRate <", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateLessThanOrEqualTo(String value) {
            addCriterion("winRate <=", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateLike(String value) {
            addCriterion("winRate like", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateNotLike(String value) {
            addCriterion("winRate not like", value, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateIn(List<String> values) {
            addCriterion("winRate in", values, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateNotIn(List<String> values) {
            addCriterion("winRate not in", values, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateBetween(String value1, String value2) {
            addCriterion("winRate between", value1, value2, "winrate");
            return (Criteria) this;
        }

        public Criteria andWinrateNotBetween(String value1, String value2) {
            addCriterion("winRate not between", value1, value2, "winrate");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Integer value) {
            addCriterion("experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Integer value) {
            addCriterion("experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Integer value) {
            addCriterion("experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Integer value) {
            addCriterion("experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Integer> values) {
            addCriterion("experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Integer> values) {
            addCriterion("experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Integer value1, Integer value2) {
            addCriterion("experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("experience not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
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