package com.yiscn.entity;

public class ScRobotConfig {
    private Integer id;

    private String robotname;

    private String robothead;

    private Integer robotarea;

    private Integer robotrate;

    private Boolean robotisuse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRobotname() {
        return robotname;
    }

    public void setRobotname(String robotname) {
        this.robotname = robotname == null ? null : robotname.trim();
    }

    public String getRobothead() {
        return robothead;
    }

    public void setRobothead(String robothead) {
        this.robothead = robothead == null ? null : robothead.trim();
    }

    public Integer getRobotarea() {
        return robotarea;
    }

    public void setRobotarea(Integer robotarea) {
        this.robotarea = robotarea;
    }

    public Integer getRobotrate() {
        return robotrate;
    }

    public void setRobotrate(Integer robotrate) {
        this.robotrate = robotrate;
    }

    public Boolean getRobotisuse() {
        return robotisuse;
    }

    public void setRobotisuse(Boolean robotisuse) {
        this.robotisuse = robotisuse;
    }
}