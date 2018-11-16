package com.yiscn.common.util;


import org.apache.commons.net.util.Base64;

/**
 * Created by BVC on 2017/5/11.
 */
public class SecretUtil {
    /**
     * 16进制字符串转普通字符串
     * @param hexString
     * @param charSet
     * @return
     */
    public static String hexToSting(String hexString,String charSet){
        byte[] byStr = new byte[hexString.length() / 2];
        for (int i = 0; i < byStr.length; i++) {
            try {
                byStr[i] = (byte) (0xff & Integer.parseInt(hexString.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String s = "";
        try {
            s = new String(byStr, charSet);// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 16进制字符串转字节
     * @param hexString
     * @return
     */
    public static byte[] hexToByte(String hexString){
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    /**
     * 普通字符串转16进制字符串
     * @param str
     * @return
     */
    public static String stringToHexString(String str){
        byte[] byStr = str.getBytes();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byStr.length; i++) {
            sb.append(Integer.toHexString(byStr[i]));
        }
        return sb.toString();
    }

    /**
     * 字节转16进制 字符串
     * @param src
     * @return
     */
    public static String byteToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    /**
     * base64字符串转字节
     * @param base64String
     * @return
     */
    public static byte[] decodeBase64(String base64String){
        return  Base64.decodeBase64(base64String);
    }

    /**
     * 字节转base64字符串
     * @param bytes
     * @return
     */
    public static String encodeBase64(byte[] bytes){
        return Base64.encodeBase64String(bytes);
    }

}
