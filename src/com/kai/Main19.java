package com.kai;

import java.util.regex.Pattern;

/**
 * Created by FengKai on 2018/3/8.
 */
public class Main19 {

    public static void main(String[] args) {
        String scoreInput = "30.4";
        if(judgeOneDecimal(scoreInput)){
            System.out.println(1);
            double b = Double.parseDouble(scoreInput);
            Double scoreMaxInt = b * 100;
            System.out.println(b);
            System.out.println(scoreMaxInt.intValue());
        }else{
            System.out.println(2);
        }

    }


    /**
     * 判断非负数的整数或者携带一位的小数
     * @param source
     * @return boolean
     */
    private static boolean judgeOneDecimal(String source){
        boolean flag = false;
        if(source != null){
            // 判断是否是整数或者是携带一位的小数
            Pattern pattern = Pattern.compile("^[+]?([0-9]+(.[0-9])?)$");
            if(pattern.matcher(source).matches()){
                flag = true;
            }
        }
        return flag;
    }
}
