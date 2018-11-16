package com.yiscn.entity;

import java.util.ArrayList;
import java.util.List;

public class ScUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScUserExample() {
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

        public Criteria andNicknameIsNull() {
            addCriterion("nickName is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickName is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickName =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickName <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickName >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickName >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickName <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickName <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickName like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickName not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickName in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickName not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickName between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickName not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Boolean value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Boolean value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Boolean value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Boolean value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Boolean> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Boolean> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andHeadIsNull() {
            addCriterion("head is null");
            return (Criteria) this;
        }

        public Criteria andHeadIsNotNull() {
            addCriterion("head is not null");
            return (Criteria) this;
        }

        public Criteria andHeadEqualTo(String value) {
            addCriterion("head =", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotEqualTo(String value) {
            addCriterion("head <>", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThan(String value) {
            addCriterion("head >", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThanOrEqualTo(String value) {
            addCriterion("head >=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThan(String value) {
            addCriterion("head <", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThanOrEqualTo(String value) {
            addCriterion("head <=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLike(String value) {
            addCriterion("head like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotLike(String value) {
            addCriterion("head not like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadIn(List<String> values) {
            addCriterion("head in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotIn(List<String> values) {
            addCriterion("head not in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadBetween(String value1, String value2) {
            addCriterion("head between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotBetween(String value1, String value2) {
            addCriterion("head not between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openId not between", value1, value2, "openid");
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

        public Criteria andCurtimeIsNull() {
            addCriterion("curTime is null");
            return (Criteria) this;
        }

        public Criteria andCurtimeIsNotNull() {
            addCriterion("curTime is not null");
            return (Criteria) this;
        }

        public Criteria andCurtimeEqualTo(String value) {
            addCriterion("curTime =", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeNotEqualTo(String value) {
            addCriterion("curTime <>", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeGreaterThan(String value) {
            addCriterion("curTime >", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeGreaterThanOrEqualTo(String value) {
            addCriterion("curTime >=", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeLessThan(String value) {
            addCriterion("curTime <", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeLessThanOrEqualTo(String value) {
            addCriterion("curTime <=", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeLike(String value) {
            addCriterion("curTime like", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeNotLike(String value) {
            addCriterion("curTime not like", value, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeIn(List<String> values) {
            addCriterion("curTime in", values, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeNotIn(List<String> values) {
            addCriterion("curTime not in", values, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeBetween(String value1, String value2) {
            addCriterion("curTime between", value1, value2, "curtime");
            return (Criteria) this;
        }

        public Criteria andCurtimeNotBetween(String value1, String value2) {
            addCriterion("curTime not between", value1, value2, "curtime");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
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