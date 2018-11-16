package com.yiscn.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringBootLogger {

    /**
     * 使用sl4j门面,容器中具体的实现可以是log4j2 logback
     */
    private static final Logger logger = LoggerFactory.getLogger(SpringBootLogger.class);

    public static void info(String info){
        logger.info(info);
    }
    public  static  void debug(String debugInfo){
        logger.debug(debugInfo);
    }
    public  static void  error(String errorMsg){
        logger.error(errorMsg);
    }

    public  static  void error(String msg, Exception e){
        logger.error(msg, e);
    }
    public static  void trace(String msg){
        logger.trace(msg);
    }

    public static  void warn(String msg){
        logger.warn(msg);
    }

}
