package com.yiscn.entity;

public class ScRankSet {
    private Integer id;

    private Integer maxRank;

    private String matchRuleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(Integer maxRank) {
        this.maxRank = maxRank;
    }

    public String getMatchRuleName() {
        return matchRuleName;
    }

    public void setMatchRuleName(String matchRuleName) {
        this.matchRuleName = matchRuleName == null ? null : matchRuleName.trim();
    }
}