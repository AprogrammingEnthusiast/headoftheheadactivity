package com.yiscn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiscn.common.bean.CommonConfig;
import com.yiscn.common.bean.PageBean;
import com.yiscn.entity.ScCombatRecord;
import com.yiscn.entity.ScCombatRecordExample;
import com.yiscn.entity.ScMatchConfig;
import com.yiscn.entity.ScUser;
import com.yiscn.mapper.ScCombatRecordMapper;
import com.yiscn.model.Room;
import com.yiscn.service.IScCombatRecordService;
import com.yiscn.service.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 比赛记录
 *
 * @param
 * @author wangj
 * @date 2018/7/10 16:33
 * @return Life is so short,do something to make yourself happy,such as coding
 */
@Service("scCombatRecordServiceImpl")
public class ScCombatRecordServiceImpl implements IScCombatRecordService {

    @Autowired(required = false)
    private ScCombatRecordMapper scCombatRecordMapper;
    @Autowired
    private IScUserService scUserService;
    @Autowired
    private CommonConfig commonConfig;


    @Override
    public void add(ScCombatRecord scCombatRecord) {
        scCombatRecordMapper.insert(scCombatRecord);
    }

    /**
     * 比赛结束记录入库
     *
     * @param room
     * @param type 比赛类型 1：排位 2：好友对战
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addForRoom(Room room, Integer type) throws Exception {
        //添加比赛记录
        addCombat(room, type);
        //修改用户信息

        Integer winUserId = 0;
        final Integer homeScore = room.getHomeScore();
        final Integer awayScore = room.getAwayScore();
        if (homeScore > awayScore) {
            //主场分数大于客场
            winUserId = room.getHomeUser().getUid();
        } else if (homeScore < awayScore) {
            //客场分数大于主场
            winUserId = room.getAwayUser().getUid();
        }

        List<ScUser> scUsers = roomToHomeUser(winUserId, room);
        ScUser homeScUser = scUsers.get(0);
        if (homeScUser != null) {
            final Integer update = scUserService.update(homeScUser);
            if (update <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }

        ScUser awayScUser = scUsers.get(1);
        if (awayScUser != null) {
            final Integer update1 = scUserService.update(awayScUser);
            if (update1 <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
    }

    @Override
    public PageBean<ScCombatRecord> getPageBean(Integer userId,Integer areaId,Integer relust,
                                                Integer pageNum, Integer pageSize) {
        ScCombatRecordExample example = new ScCombatRecordExample();
        ScCombatRecordExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if(areaId != null && "".equals(areaId)){
            criteria.andAreaidEqualTo(areaId);
        }
        if(relust != null && "".equals(relust)){
            criteria.andAreaidEqualTo(relust);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ScCombatRecord> scCombatRecords = scCombatRecordMapper.selectByExample(example);
        PageInfo<ScCombatRecord> pageInfo = new PageInfo<>(scCombatRecords);
        return new PageBean<>(pageInfo);
    }

    /**
     * 把房间中的主场用户拆离出来
     *
     * @param room
     * @return
     */
    private List<ScUser> roomToHomeUser(Integer winUserId, Room room) {

        List<ScUser> reslutList = new ArrayList<>(2);

        final ScMatchConfig nowScmatchConfig = commonConfig.getScMatchConfigs().get(room.getAreaId());

        //主场对象
        final Integer homeUid = room.getHomeUser().getUid();
        ScUser homescUser = scUserService.get(homeUid);

        //客场对象
        final Integer awayUid = room.getAwayUser().getUid();
        ScUser awayscUser = scUserService.get(awayUid);

        //当场比赛获得积分
        Integer addExp = nowScmatchConfig.getRewardExperience();

        if (winUserId.equals(homeUid)) {
            //主胜
            //主场对象
            winUser(homescUser, addExp, true);
            //客场
            donUser(awayscUser);
        } else if (winUserId == null || winUserId == 0) {
            //平局
            addExp = addExp / 2;
            draw(homescUser, addExp);
            draw(awayscUser, addExp);
        } else {
            //客胜
            //客场对象
            winUser(awayscUser, addExp, true);
            //主场对象
            donUser(homescUser);
        }

        reslutList.add(homescUser);
        reslutList.add(awayscUser);
        return reslutList;
    }

    /**
     * 平局
     *
     * @param scUser
     * @param addExp
     */
    private void draw(ScUser scUser, Integer addExp) {
        winUser(scUser, addExp, false);
    }

    /**
     * 加分逻辑
     *
     * @param scUser
     * @param addExp
     * @param isVictort 是否添加连胜
     */
    private void winUser(ScUser scUser, Integer addExp, Boolean isVictort) {
        Integer experience = scUser.getExperience();
        Integer levelExp = commonConfig.getExperienceMap().get(scUser.getLevel());
        int homeOverExp = experience + addExp;
        if (homeOverExp >= levelExp) {
            scUser.setExperience(homeOverExp - levelExp);
            final int nowLevel = scUser.getLevel() + 1;
            scUser.setLevel(nowLevel);
            //判断段位是否需要更新
            ScMatchConfig useMatchConfig = commonConfig.getScMatchConfigs().get(scUser.getParagraph());
            if (nowLevel > useMatchConfig.getMaxGrade()) {
                scUser.setParagraph(scUser.getParagraph() + 1);
            }
        } else {
            scUser.setExperience(homeOverExp);
        }
        if (isVictort) {
            //判断连胜逻辑
            final int win = scUser.getNowvictory() + 1;
            if (win > scUser.getHeightvictory()) {
                scUser.setHeightvictory(win);
            }
            Integer allField = scUser.getAllfield() + 1;
            Integer winField = scUser.getWinfield() + 1;
            scUser.setNowvictory(scUser.getNowvictory() + 1);
            scUser.setAllfield(allField);
            scUser.setWinfield(winField);
            //胜率计算
            scUser.setWinrate(mathRate(winField, allField));
        } else {
            donUser(scUser);
        }
    }

    /**
     * 连胜终端逻辑
     *
     * @param awayscUser
     */
    private void donUser(ScUser awayscUser) {
        Integer allField = awayscUser.getAllfield() + 1;
        Integer winField = awayscUser.getWinfield();
        awayscUser.setNowvictory(0);
        awayscUser.setAllfield(allField);
        awayscUser.setWinfield(winField);
        //胜率计算
        awayscUser.setWinrate(mathRate(winField, allField));
    }

    /**
     * 计算胜率
     *
     * @param winField
     * @param allField
     */
    private String mathRate(Integer winField, Integer allField) {
        final double d = (double) winField / allField;
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }

    /**
     * 添加比赛记录
     *
     * @param room
     * @param type
     */
    private void addCombat(Room room, Integer type) {
        ScCombatRecord home = new ScCombatRecord();
        ScCombatRecord away = new ScCombatRecord();

        home.setUserId(room.getHomeUser().getUid());
        home.setCurtime(room.getBeginTime());
        home.setEndtime(room.getEndTime());

        away.setUserId(room.getAwayUser().getUid());
        away.setCurtime(room.getBeginTime());
        away.setEndtime(room.getEndTime());

        final Integer homeScore = room.getHomeScore();
        final Integer awayScore = room.getAwayScore();
        if (homeScore > awayScore) {
            home.setResult(1);
            away.setResult(2);
        } else if (homeScore < awayScore) {
            home.setResult(2);
            away.setResult(1);
        } else {
            home.setResult(0);
            away.setResult(0);
        }

        home.setScore(room.getHomeScore());
        away.setScore(room.getAwayScore());

        home.setType(type);
        home.setAreaid(room.getAreaId());

        away.setType(type);
        away.setAreaid(room.getAreaId());

        add(home);
        add(away);
    }
}
