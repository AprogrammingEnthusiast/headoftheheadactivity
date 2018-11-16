package com.yiscn.common.bean;

import com.yiscn.entity.*;
import com.yiscn.model.SubjectVo;
import com.yiscn.service.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    配置参数
 *
 * @author wangj
 * @date 2018/7/18 13:44
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Component
@ConfigurationProperties(prefix = "initconfig")
public class CommonConfig {

    @Autowired
    private IScRankSetService scRankSetService;
    @Autowired
    private IScMatchConfigService scMatchConfigService;
    @Autowired
    private IScTitleConfigService scTitleConfigService;
    @Autowired
    private IScSubjectTypeService scSubjectTypeService;
    @Autowired
    private IScRobotService scRobotService;
    @Autowired
    private IScSubjectService scSubjectService;

    /**
     * 经验规则维护map
     */
    private Map<Integer,Integer> experienceMap = new HashMap<>();

    /**
     * 是否开启排位pvp对战
     */
    private Boolean matchingPVP;

    /**
     * 是否开启好友对战
     */
    private Boolean fiendPVP;

    /**
     * 是否开启学习小组
     */
    private Boolean learnPVP;

    /**
     * 最多排名位数
     */
    private Integer maxRank;

    /**
     * 排位区域规则
     */
    private Map<Integer,ScMatchConfig> scMatchConfigs;

    /**
     * 称号规则
     */
    private Map<Integer,ScTitleConfig> scTitleConfigs;

    /**
     * 题目类型
     */
    private Map<Integer,ScSubjectType> scSubjectTypes;

    /**
     * 机器人配置
     */
    private Map<Integer,Set<ScRobotConfig>> scRobotConfigs;

    /**
     * 题库管理(注：此集合只有题目，答案和题目番号需要单独装配)
     */
    private Map<Integer,Set<ScSubject>> scSubjects;

    /**
     * 启动加载配置
     */
    @PostConstruct
    public void updateConfig(){
        putMaxRank();
        putMatchConfig();
        putSubjectTypeConfig();
        putTitleConfig();
        putRobotConfig();
        putSubject();
    }

    /**
     * 添加题目
     */
    public void putSubject() {
        if(getScSubjects()!=null){
            getScSubjects().clear();
        }
        setScSubjects(scSubjectService.getIusse());
    }

    /**
     * 加载机器人配置
     */
    public void putRobotConfig(){
        if(getScRobotConfigs()!=null){
            getScRobotConfigs().clear();
        }
        setScRobotConfigs(scRobotService.getConfig());
    }

    /**
     * 加载排行榜最多显示人数配置
     */
    public void putMaxRank(){
        if(getMaxRank()!=null){
            setMaxRank(null);
        }
        ScRankSet byId = scRankSetService.get();
        setMaxRank(byId.getMaxRank());
    }

    /**
     * 加载排位赛参数配置
     */
    public void putMatchConfig(){
        if(getScMatchConfigs()!=null){
            getScMatchConfigs().clear();
        }
        Map<Integer,ScMatchConfig> map = new HashMap<>(4);
        AtomicInteger n = new AtomicInteger(1);
        scMatchConfigService.getList().stream().forEach(e -> {map.put(n.get(),e);n.getAndAdd(1);});
        setScMatchConfigs(map);
    }

    /**
     * 加载称号参数配置
     */
    public void putTitleConfig(){
        if(getScTitleConfigs()!=null){
            getScTitleConfigs().clear();
        }
        Map<Integer,ScTitleConfig> map = new HashMap<>(7);
        AtomicInteger n = new AtomicInteger(1);
        scTitleConfigService.getList().stream().forEach(e -> {map.put(n.get(),e);n.getAndAdd(1);});
        setScTitleConfigs(map);
    }

    /**
     * 加载题目类型参数配置
     */
    public void putSubjectTypeConfig(){
        if(getScSubjectTypes()!=null){
            getScSubjectTypes().clear();
        }
        Map<Integer,ScSubjectType> map = new HashMap<>(5);
        AtomicInteger n = new AtomicInteger(1);
        scSubjectTypeService.getList().stream().forEach(e -> {map.put(n.get(),e);n.getAndAdd(1);});
        setScSubjectTypes(map);
    }

    public IScRankSetService getScRankSetService() {
        return scRankSetService;
    }

    public void setScRankSetService(IScRankSetService scRankSetService) {
        this.scRankSetService = scRankSetService;
    }

    public Map<Integer, Integer> getExperienceMap() {
        return experienceMap;
    }

    public void setExperienceMap(Map<Integer, Integer> experienceMap) {
        this.experienceMap = experienceMap;
    }

    public Integer getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(Integer maxRank) {
        this.maxRank = maxRank;
    }

    public Map<Integer, ScMatchConfig> getScMatchConfigs() {
        return scMatchConfigs;
    }

    public void setScMatchConfigs(Map<Integer, ScMatchConfig> scMatchConfigs) {
        this.scMatchConfigs = scMatchConfigs;
    }

    public Map<Integer, ScTitleConfig> getScTitleConfigs() {
        return scTitleConfigs;
    }

    public void setScTitleConfigs(Map<Integer, ScTitleConfig> scTitleConfigs) {
        this.scTitleConfigs = scTitleConfigs;
    }

    public Map<Integer, ScSubjectType> getScSubjectTypes() {
        return scSubjectTypes;
    }

    public void setScSubjectTypes(Map<Integer, ScSubjectType> scSubjectTypes) {
        this.scSubjectTypes = scSubjectTypes;
    }

    public Map<Integer, Set<ScRobotConfig>> getScRobotConfigs() {
        return scRobotConfigs;
    }

    public void setScRobotConfigs(Map<Integer, Set<ScRobotConfig>> scRobotConfigs) {
        this.scRobotConfigs = scRobotConfigs;
    }

    public Map<Integer, Set<ScSubject>> getScSubjects() {
        return scSubjects;
    }

    public void setScSubjects(Map<Integer, Set<ScSubject>> scSubjects) {
        this.scSubjects = scSubjects;
    }

    public IScMatchConfigService getScMatchConfigService() {
        return scMatchConfigService;
    }

    public void setScMatchConfigService(IScMatchConfigService scMatchConfigService) {
        this.scMatchConfigService = scMatchConfigService;
    }

    public Boolean getMatchingPVP() {
        return matchingPVP;
    }

    public void setMatchingPVP(Boolean matchingPVP) {
        this.matchingPVP = matchingPVP;
    }

    public Boolean getFiendPVP() {
        return fiendPVP;
    }

    public void setFiendPVP(Boolean fiendPVP) {
        this.fiendPVP = fiendPVP;
    }

    public Boolean getLearnPVP() {
        return learnPVP;
    }

    public void setLearnPVP(Boolean learnPVP) {
        this.learnPVP = learnPVP;
    }
}
