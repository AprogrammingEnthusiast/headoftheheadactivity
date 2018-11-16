package com.yiscn.common.util;


import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by DengLibin on 2017/9/19.
 */
public class StringUtil {
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 根据身份这证号计算生日
     * @param identityNo
     * @return
     */
    public static String getBirthday(String identityNo) {

       String birthDay =  identityNo.substring(6, 10) +
                        "-" +
                        identityNo.substring(10, 12) +
                        "-" +
                        identityNo.substring(12, 14);
        return birthDay;
    }


    //由出生日期获得年龄
    public static int getAge(String birthDay) {
        Date birthDate = DateUtil.getDate(birthDay,"yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDate);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            }else{
                age--;
            }
        }
        return age;
    }

    /**
     * 获取随机数字字符串
     * @param length
     * @return
     */
    public static String getRandomNumString(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static  boolean isEmpty(String ... args){
        for(String arg : args){
            if(arg == null || args.length == 0){
                return true;
            }
        }
        return false;
    }
}
