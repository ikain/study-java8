package com.kai;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by FengKai on 2017/12/21.
 */
public class Main8 {

    public static void main(String[] args){
        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1,2,3,4),
                Arrays.asList(5,6,7,8),
                Arrays.asList(9,7)
        );
        //listStream.flatMap(e->e.stream());
        listStream.flatMap(Collection::stream).forEach(System.out::print);
        System.out.println();
        Stream<String> stream1 = Stream.of("tom#Li","lucy#Liu");
        stream1.flatMap(e->Stream.of(e.split("#"))).forEach(System.out::println);
        System.out.println();
        Stream intStream = Stream.generate(()->(int)(Math.random()*100)).limit(100).sorted();
        intStream.forEach(System.out::println);
        Stream.iterate(2,n->n+3).limit(10).forEach(System.out::println);

    }
}
