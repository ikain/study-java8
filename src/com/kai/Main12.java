package com.kai;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
        //Function<T, R> -T作为输入，返回的R作为输出
        Function<String, String> toInteger = String::toUpperCase;
        String k = toInteger.apply("abcD");//
        System.out.println(k);
        String s = toInteger.andThen(String::toLowerCase).apply("abcD");
        System.out.println(s);
        String d = toInteger.andThen(x->x.toLowerCase()).apply("asddD");
        String c = toInteger.compose(x->x.toString()).apply("dsa");

        //Supplier<T> - 没有任何输入，返回T
        //Supplier接口产生一个给定类型的结果。与Function不同的是，Supplier没有输入参数。
        Supplier<String> supplier = () -> { return "SAX"; };
        System.out.println(supplier.get());

        //Consumer<T> - T作为输入，执行某种动作但没有返回值
        //Consumer代表了在一个输入参数上需要进行的操作
        Consumer<Person> personConsumer = x -> { System.out.println("print:"+x.toString()); };
        PersonFactory<Person> personFactory = Person::new;
        personConsumer.accept(personFactory.create("Consumers","88"));

        //Comparators
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };
        Person person1 = personFactory.create("Person1","13");
        Person person2 = personFactory.create("Person2","12");
        Person person3 = personFactory.create("Person3","14");
        int sortVal = comparator.compare(person1,person2);
        System.out.println(sortVal);

        List<Person> personList = Arrays.asList(person1,person2,person3);
        Collections.sort(personList,comparator.reversed());//反转排序
        personList.forEach(x-> System.out.println(x.toString()));
        System.out.println("=============");
        personList.sort((x,y)->x.getAge().compareTo(y.getAge()));
        //personList.sort(Comparator.comparing(Person::getAge));
        personList.forEach(x-> System.out.println(x.toString()));

    }
}
