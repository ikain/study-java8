package com.kai;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by FengKai on 2017/12/21.
 */
public class Main7 {

    public static void main(String[] args) {
        //Stream的构建方式
        //使用值构建
        Stream<String> stringStream = Stream.of("A","B","C","D");
        //使用数组
        String[] strArray = new String[]{"A","B","C","D"};
        stringStream = Stream.of(strArray);
        stringStream = Arrays.stream(strArray);
        //使用集合
        List<String> strList = Arrays.asList(strArray);
        stringStream = strList.stream();

        //构建int Stream
        IntStream intStream = IntStream.of(1,2,3,4);//输出1234
        intStream.forEach(s-> System.out.print(s+","));
        System.out.println();
        intStream = IntStream.range(1,3);//输出12
        intStream.forEach(s-> System.out.print(s+","));
        System.out.println();
        intStream = IntStream.rangeClosed(1,3);//输出123
        intStream.forEach(s-> System.out.print(s+","));
        System.out.println();

        //steam转为其他类型
        //转为数组
        String[] strArrayTwo = stringStream.toArray(String[]::new);
        System.out.println(Arrays.toString(strArrayTwo));
        //转为集合
        List<String> strListTwo = null;
        strListTwo = Stream.of("A","B","C","D").collect(Collectors.toList());
        strListTwo = Stream.of("A","B","C","D").collect(Collectors.toCollection(LinkedList::new));
        //转为Set
        Set<String> strSet = null;
        strSet = Stream.of("A","B","C","D").collect(Collectors.toSet());
        strSet = Stream.of("A","B","C","D").collect(Collectors.toCollection(HashSet::new));
        //转为String
        String strJoin = Stream.of("A","B","C","D").collect(Collectors.joining(","));
        System.out.println(strJoin);

    }
}
