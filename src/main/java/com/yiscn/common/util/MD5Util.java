package com.yiscn.common.util;

import java.security.MessageDigest;


public class MD5Util {
	public static String getMd5(String str)  {
		try{
			MessageDigest md5 = null;		
			md5 = MessageDigest.getInstance("MD5");		
			byte[] bs = md5.digest(str.getBytes("utf-8"));
			StringBuilder sb = new StringBuilder(40);
			
			for(byte x:bs){
		        if((x & 0xff)>>4 == 0) {
		            sb.append("0").append(Integer.toHexString(x & 0xff));
		        }else{
		            sb.append(Integer.toHexString(x & 0xff));
		        }
			}
	        return sb.toString();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
}
