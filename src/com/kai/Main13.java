package com.kai;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by FengKai on 2018/1/4.
 */
public class Main13 {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream().sorted((x, y) -> x.compareTo(y)).forEach(System.out::println);

        //match
        boolean anyB = stringCollection.stream().anyMatch(x -> x.startsWith("d"));
        System.out.println("满足任意一个:" + anyB);
        boolean allB = stringCollection.stream().allMatch(x -> x.contains("d"));
        System.out.println("全部满足:" + allB);
        boolean noneB = stringCollection.stream().noneMatch(x -> x.startsWith("z"));
        System.out.println("无满足:" + noneB);

        //count
        long count = stringCollection.stream().filter(x -> x.startsWith("d")).count();
        System.out.println("满足条件的个数:" + count);

        //reduce
        //该操作是一个终结操作，它能够通过某一个方法，对元素进行削减操作。该操作的结果会放在一个Optional变量里返回。
        Optional<String> reduced = stringCollection.stream().sorted().reduce((x, y) -> x + " # " + y);
        reduced.ifPresent(System.out::println);
    }
}
