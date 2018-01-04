package com.kai;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Kai on 2015/7/4.
 */
public class Main1 {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //java 8
        new Thread(()-> System.out.println("我进来了大大是大事发生")).start();
        System.out.println("==========");
        Date date = new Date();
        //java 7
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }).start();

        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        System.out.println("==========");
        features.forEach(System.out::println);
        System.out.println("==========");
        features.forEach(n -> System.out.println(n));

        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("==========");
        filter(languages, (str)->true);
        System.out.println("==========");
        filter(languages, (str)->((String)str).startsWith("S"));
        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        System.out.println("==========");
        Predicate<String> startWithL = (s -> s.startsWith("L"));
        Predicate<String> lengthEqual = s -> s.length()==4;
        languages.stream().filter(startWithL.and(lengthEqual)).forEach(n-> System.out.println(n));

    }

    private static void filter(List<String> names, Predicate predicate){
        names.stream().filter(
                (n) -> (predicate.test(n))
                )
                .forEach(System.out::println);
        //names.stream().filter((name) -> (predicate.test(name))).forEach((name) -> { System.out.println(name + " "); });
    }
}
