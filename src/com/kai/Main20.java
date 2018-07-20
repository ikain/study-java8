package com.kai;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by FengKai on 2018/3/19.
 */
public class Main20 {

    public static void main(String[] args) {
        System.out.println(testTry());
        String type = "1";
        switch (type) {
            case "1":
                System.out.println(1111);
                break;
            case "2":
                System.out.println(1111);
                break;
            default:
                break;
        }

        BigDecimal big = new BigDecimal("2.61").setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(big.doubleValue());


        Optional<String[]> idsArray = Optional.of("A,B,C").map(ids -> ids.split(","));
        if (!idsArray.isPresent()) {
            System.out.println("null");
        }
        System.out.println(Arrays.toString(idsArray.orElse(null)));
    }

    public static int testTry(){
        int x=0;
        try {
            System.out.println("try");
            return ++x;
        } finally {
            System.out.println("finally");
            ++x;
        }
    }

}
