package com.yiscn.util;

import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.socket.QualifyingSocket;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 *    机器人集合工具类
 *
 * @author wangj
 * @date 2018/7/24 9:06
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public class RobotListUtil {

    private static CommonUtil RobotOne = new CommonUtil();

    private static CommonUtil RobotTwo = new CommonUtil();

    private static CommonUtil RobotThree = new CommonUtil();

    private static CommonUtil RobotFour = new CommonUtil();

    /**
     * 根据分区id获取机器人集合
     * @param areaId
     * @return
     */
    public static CommonUtil getRobotMath(Integer areaId){
        CommonUtil commonUtil = null;
        switch (areaId){
            case 1:commonUtil = RobotOne;break;
            case 2:commonUtil = RobotTwo;break;
            case 3:commonUtil = RobotThree;break;
            case 4:commonUtil = RobotFour;break;
            default:break;
        }
        if(commonUtil == null){
            SpringBootLogger.error("获取机器人集合传入错误区域id");
        }
        return commonUtil;
    }
}
