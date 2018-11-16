package com.yiscn.common.util;

import com.yiscn.common.exception.NullFieldException;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class FieldUtil {
	/**
	 * 获取类的所有字段名
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static<T> String[] getFieldNames(Class<T> clazz){
		Field[] fields = clazz.getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for(int i = 0;i <  fieldNames.length;i++){
			fields[i].setAccessible(true);
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	/**
	 * 返回javabean所有null的字段名（不包含id）
	 * @param clazz
	 * @param t
	 * @param <T>
	 * @return
	 */
	public static <T> List<String> getNullFiledNames(Class<T> clazz, T t){
		List<String> nullFieldNames = new LinkedList<>();
		Method[] methods = clazz.getMethods();
		//判断字段是否为空
		for(Method method : methods){
			String methodName = method.getName();
			if(methodName.startsWith("get") && !methodName.equals("getId")){
				try {
					Object o = method.invoke(t, null);
					if(o == null){
						nullFieldNames.add(methodName.substring(3).toLowerCase());
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return nullFieldNames;
	}
	/**
	 * 属性拷贝,忽略null
	 * @param dest
	 * @param src
	 * @param <T>
	 */
	public static <T> void copyProperties(T dest,T src,Class<T> clazz) throws Exception{
		Field[] fields = clazz.getDeclaredFields();
		for(int i = 0; i< fields.length; i++){
			Field field = fields[i];
			field.setAccessible(true);
			String fieldName = field.getName();
				Method methodGet = clazz.getDeclaredMethod("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1,fieldName.length()));
				methodGet.setAccessible(true);
				Object o = methodGet.invoke(src);
				Method methodSet = clazz.getDeclaredMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1,fieldName.length()),field.getType());
				methodSet.setAccessible(true);
				if(o != null){
					methodSet.invoke(dest,o);
				}
			}
	}

	/**
	 * 对象属性转换为字段  例如：userName to user_name
	 * @param property 字段名
	 * @return
	 */
	public static String propertyToField(String property) {
		if (null == property) {
			return "";
		}
		char[] chars = property.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (char c : chars) {
			if (CharUtils.isAsciiAlphaUpper(c)) {
				sb.append("_" + StringUtils.lowerCase(CharUtils.toString(c)));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 字段转换成对象属性 例如：user_name to userName
	 * @param field
	 * @return
	 */
	public static String fieldToProperty(String field) {
		if (null == field) {
			return "";
		}
		char[] chars = field.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '_') {
				int j = i + 1;
				if (j < chars.length) {
					sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));
					i++;
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}


	public static<W> void checkNullFiled(W javaBean) throws IllegalAccessException, NullFieldException {
			if(javaBean == null){
				throw new NullFieldException("对象不能为空");
			}
			Class<?> clazz = javaBean.getClass();
			Field[] fields = clazz.getFields();
			for(Field field : fields){
				field.setAccessible(true);
				Object value = field.get(javaBean);
				if(value == null){
					throw new NullFieldException(field.getName()+"不能为空");
				}
			}
	}
	public static<W> void checkNullFiled(W javaBean,String ... excludeFields) throws IllegalAccessException, NullFieldException {
		if(javaBean == null){
			throw new NullFieldException("对象不能为空");
		}
		Class<?> clazz = javaBean.getClass();
		Field[] fields = clazz.getDeclaredFields();
		A:for(Field field : fields){
			for(String excludeField:excludeFields){
				if(field.getName().equals(excludeField)){
					continue A;
				}
			}
			field.setAccessible(true);
			Object value = field.get(javaBean);
			if(value == null){
				throw new NullFieldException(field.getName()+"不能为空");
			}
		}
	}
}
