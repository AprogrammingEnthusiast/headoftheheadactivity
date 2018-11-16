package com.yiscn.common.util;

import java.math.BigDecimal;

/**
 * 精确计算工具类
 * @author DengLibin
 *
 */
public class CaculateUtil {
	/**
	 * 加
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String add(String num1,String num2){
		BigDecimal a = new BigDecimal(num1);
		BigDecimal b = new BigDecimal(num2);
		return a.add(b).toString();
	}

	/**
	 * 减
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String subtract(String num1,String num2){
		BigDecimal a = new BigDecimal(num1);
		BigDecimal b = new BigDecimal(num2);
		return a.subtract(b).toString();
	}

	/**
	 * 乘
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String multiply(String num1,String num2){
		BigDecimal a = new BigDecimal(num1);
		BigDecimal b = new BigDecimal(num2);
		return a.multiply(b).toString();
	}

	/**
	 * 除
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String divide(String num1,String num2){
		BigDecimal a = new BigDecimal(num1);
		BigDecimal b = new BigDecimal(num2);
		return a.divide(b).toString();
	}
	
}
