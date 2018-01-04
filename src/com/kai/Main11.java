package com.kai;

import java.util.function.Predicate;

/**
 * Created by FengKai on 2018/1/4.
 */
public class Main11 {
    public static void main(String[] args) {
        Foumula foumula = (s, c) -> s + c;
        foumula = new Foumula() {
            @Override
            public int sum(int o, int c) {
                return 0;
            }

            @Override
            public int sqrt(int o) {
                return 0;
            }

        };

        new Thread(() -> System.out.println("println")).start();
        new Runnable() {
            @Override
            public void run() {

            }
        };

        //定义一个String变量必须>0 匿名实现Predicate接口的test方法 返回必须boolean类型
        /*predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };*/
        //Predicate<T> -T作为输入，返回的boolean值作为输出
        Predicate<String> predicate = s -> s.length() > 0;
        //返回true
        System.out.println(predicate.test("foo"));
        //negate作用取反 返回 false
        System.out.println(predicate.negate().test("foo"));
        //and 方法 将多个条件联合 起来 test 方法 必须同时满足
        System.out.println(predicate.and(s -> s.startsWith("f")).test("foo"));
        //or 方法 将多个条件 满足其一 就 返回true
        System.out.println(predicate.or(s -> s.indexOf("q") > 0).test("foo"));

    }
}

class Lambda1 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        //在匿名lambda中可以获取成员变量 和静态成员变量的 读写权
        Converter<String, Integer> converter = from -> {
            outerStaticNum = 1;
            return String.valueOf(from + outerStaticNum);
        };

        Converter<String, Integer> converter1 = from -> {
            outerNum = 1;
            return String.valueOf(from + outerNum);
        };
    }
}

@FunctionalInterface
interface Foumula {

    int sum(int o, int c);

    //java8 默认 default 接口方法也能被重写
    default int sqrt(int o) {
        return o * 10;
    }
}

interface Foumula2 {
    //接口中default实现的方法不能被lambda使用
    default int sqrt(int o) {
        return o + 1;
    }
}