package com.kai;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by FengKai on 2017/12/18.
 */
public class Main5 {
    //通过过滤创建一个String列表
    public static void main(String[] args){

        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        List<String> filterList = features.stream().filter(str->str.contains("m")).collect(Collectors.toList());
        filterList.forEach(System.out::println);
        System.out.println("============");
        //比如把List集合字符串拼接起来
        String stringes = features.stream().map(str->str.toUpperCase()).collect(Collectors.joining(","));
        features.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(stringes);
        //如何利用流的 distinct() 方法来对集合进行去重。
        System.out.println("============");
        List<Integer> integerList = Arrays.asList(5,9,22,3,22,1,2,1,2,3,5,2,7,7);
        integerList.stream().distinct().forEach(System.out::println);
        System.out.println("============");
        //获取数字的个数、最小值、最大值、总和以及平均值 mapToDouble / mapToLong
        IntSummaryStatistics iss = integerList.stream().mapToInt(x->x).summaryStatistics();
        System.out.println("count:"+iss.getCount());
        System.out.println("max num:"+iss.getMax());
        System.out.println("min num:"+iss.getMin());
        System.out.println("sum:"+iss.getSum());
        System.out.println("avg:"+iss.getAverage());
        System.out.println("============");
        Integer[] numArray = {1,2,3,4,5,6,7};
        Stream<Integer> caclArr = Stream.of(numArray).filter(n->n%2==0);
        Integer[] css = caclArr.toArray(Integer[]::new);
        Arrays.stream(css).forEach(System.out::println);
        Stream.of(numArray).filter(n->n%2==0).forEach(System.out::println);
    }
}
