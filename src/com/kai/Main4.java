package com.kai;

import java.util.Arrays;
import java.util.List;

/**
 * Created by FengKai on 2017/12/18.
 */
public class Main4 {
    //Java 8中使用lambda表达式的Map和Reduce示例
    public static void main(String[] args) {

        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (double cost:costBeforeTax) {
            cost = cost + cost * 0.12;
            System.out.println(cost);
        }
        System.out.println("==========");
        costBeforeTax.forEach(System.out::println);
        //java 8 方式处理
        System.out.println("==========");
        costBeforeTax.stream().map(cost->cost+cost*0.12).forEach(System.out::println);
        System.out.println("==========");
        double sumCost = costBeforeTax.stream().map(cost->cost+cost*0.12).reduce((s,c)->s+c).get();
        System.out.println(sumCost);
    }
}
