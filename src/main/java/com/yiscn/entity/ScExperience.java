package com.yiscn.entity;

public class ScExperience {
    private Integer id;

    private Integer userid;

    private Integer mouth;

    private Integer level;

    private Integer paragraph;

    private Integer heightvictory;

    private Integer nowvictory;

    private Integer allfield;

    private Integer winfield;

    private String winrate;

    private Integer experience;

    private Integer rank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMouth() {
        return mouth;
    }

    public void setMouth(Integer mouth) {
        this.mouth = mouth;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParagraph() {
        return paragraph;
    }

    public void setParagraph(Integer paragraph) {
        this.paragraph = paragraph;
    }

    public Integer getHeightvictory() {
        return heightvictory;
    }

    public void setHeightvictory(Integer heightvictory) {
        this.heightvictory = heightvictory;
    }

    public Integer getNowvictory() {
        return nowvictory;
    }

    public void setNowvictory(Integer nowvictory) {
        this.nowvictory = nowvictory;
    }

    public Integer getAllfield() {
        return allfield;
    }

    public void setAllfield(Integer allfield) {
        this.allfield = allfield;
    }

    public Integer getWinfield() {
        return winfield;
    }

    public void setWinfield(Integer winfield) {
        this.winfield = winfield;
    }

    public String getWinrate() {
        return winrate;
    }

    public void setWinrate(String winrate) {
        this.winrate = winrate == null ? null : winrate.trim();
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}