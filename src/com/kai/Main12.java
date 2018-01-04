package com.kai;

import java.util.function.Function;

/**
 * Created by FengKai on 2018/1/4.
 */
public class Main12 {
    public static void main(String[] args) {
        /*
         Function接口的主要方法：

         R apply(T t) – 将Function对象应用到输入的参数上，然后返回计算结果。

         default ‹V› Function‹T,V› – 将两个Function整合，并返回一个能够执行两个Function对象功能的Function对象。

         译者注：Function接口中除了apply()之外全部接口如下：

         default <V> Function<T,V> andThen(Function<? super R,? extends V> after) 返回一个先执行当前函数对象apply方法再执行after函数对象apply方法的函数对象。

         default <V> Function<T,V> compose(Function<? super V,? extends T> before)返回一个先执行before函数对象apply方法再执行当前函数对象apply方法的函数对象。

         static <T> Function<T,T> identity() 返回一个执行了apply()方法之后只会返回输入参数的函数对象。
         */
        //<T,R> T输入类型 R输出类型
        Function<String, String> toInteger = String::toUpperCase;
        String k = toInteger.apply("abcD");//
        System.out.println(k);
        String s = toInteger.andThen(String::toLowerCase).apply("abcD");
        System.out.println(s);
        String d = toInteger.andThen(x->x.toLowerCase()).apply("asddD");
        String c = toInteger.compose(x->x.toString()).apply("dsa");
    }
}
