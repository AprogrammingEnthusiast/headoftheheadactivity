package com.yiscn.entity;

public class ScUser {
    private Integer id;

    private String nickname;

    private Boolean gender;

    private String city;

    private Integer level;

    private String head;

    private String openid;

    private Integer paragraph;

    private String curtime;

    private Integer integral;

    private Integer heightvictory;

    private Integer nowvictory;

    private Integer allfield;

    private Integer winfield;

    private String winrate;

    private Integer experience;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getParagraph() {
        return paragraph;
    }

    public void setParagraph(Integer paragraph) {
        this.paragraph = paragraph;
    }

    public String getCurtime() {
        return curtime;
    }

    public void setCurtime(String curtime) {
        this.curtime = curtime == null ? null : curtime.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
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
}