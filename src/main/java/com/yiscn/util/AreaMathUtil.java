package com.yiscn.util;

import com.yiscn.common.util.SpringBootLogger;

/**
 *
 *    匹配分区工具
 *
 * @author wangj
 * @date 2018/7/16 13:58
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public class AreaMathUtil{

    private static CommonUtil AreaOne = new CommonUtil();

    private static CommonUtil AreaTwo = new CommonUtil();

    private static CommonUtil AreaThree = new CommonUtil();

    private static CommonUtil AreaFour = new CommonUtil();

    /**
     * 根据分区id获取排队集合
     * @param areaId
     * @return
     */
    public static CommonUtil getAreaMath(Integer areaId){
        CommonUtil commonUtil = null;
        switch (areaId){
            case 1:commonUtil = AreaOne;break;
            case 2:commonUtil = AreaTwo;break;
            case 3:commonUtil = AreaThree;break;
            case 4:commonUtil = AreaFour;break;
            default:break;
        }
        if(commonUtil == null){
            SpringBootLogger.error("获取排位分区集合输入错误集合代码");
        }
        return commonUtil;
    }
}
