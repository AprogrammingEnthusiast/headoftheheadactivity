package com.yiscn.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by DengLibin on 2017/6/5.
 */
public class ShaUtil {
    public static String SHA1(String s) {
        String s2 = null;
        try {
            s2 = bytetoString(MessageDigest.getInstance("SHA-1").digest(s.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s2;
    }

    private static String bytetoString(byte[] abyte0) {
        String s = "";
        int i = 0;
        while(i < abyte0.length)
        {
            String s1 = Integer.toHexString(0xff & abyte0[i]);
            if(s1.length() == 1)
                s = (new StringBuilder()).append(s).append("0").append(s1).toString();
            else
                s = (new StringBuilder()).append(s).append(s1).toString();
            i++;
        }
        return s.toLowerCase();
    }

}
