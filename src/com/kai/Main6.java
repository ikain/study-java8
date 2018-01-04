package com.kai;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by FengKai on 2017/12/21.
 * Optional的用法
 */
public class Main6 {

	public static void main(String[] args){
		//调用工厂方法创建Optional实例
		Optional<String> name1 = Optional.of("FirstBless");
		//传入参数为null，抛出NullPointerException.
		try {
			Optional<String> name2 = Optional.of(null);
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		//下面创建了一个不包含任何值的Optional实例
		//例如，值为'null'
		Optional<String> name3 = Optional.ofNullable(null);
		//isPresent方法用来检查Optional实例中是否包含值
		//直接打印为null的 会报java.util.NoSuchElementException
		try {
			System.out.println("name3:"+name3.get());
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
		if(name3.isPresent()){
			System.out.println("name3:"+name3.get());
		}
		//如下java8写发和如上if判断等效
		//ifPresent方法接受lambda表达式作为参数。lambda表达式对Optional的值调用consumer进行处理。
		name1.ifPresent(s -> System.out.println("name1:"+s));
		//orElse 如果有值则将其返回，否则返回指定的其它值。
		System.out.println(name1.orElse("I has value"));
		System.out.println(name3.orElse("I has no value"));
		//orElseGet与orElse方法类似，区别在于orElse传入的是默认值，
		//orElseGet可以接受一个lambda表达式生成默认值。
		//输出：Default Value
		System.out.println(name3.orElseGet(()->"Default Value"));
		//输出：Default Value
		System.out.println(name1.orElseGet(()->"Default Value"));
		try{
			//orElseThrow与orElse方法类似。与返回默认值不同，
			//orElseThrow会抛出lambda表达式或方法生成的异常
			name1.orElseThrow(NullPointerException::new);//不为null会输出值
			name3.orElseThrow(NullPointerException::new);//为null则抛此异常
		}catch (Throwable throwable){
			System.out.println(throwable);
		}
		//map的作用就是在获得value时转化一系列操作
		System.out.println(name1.map(v->v.toUpperCase()).get());//等效
		System.out.println(name1.map(String::toUpperCase).get());//等效
		System.out.println(name3.map(String::toUpperCase));//加get会报NoSumElement 不加返回Optional.empty
		System.out.println(name3.map(String::toUpperCase).orElse("no value"));//为null返回 no value
		//flatMap 只能返回Optional类型，要转换，map就支持任何类型T
		System.out.println(name1.flatMap(v->Optional.of(v.toUpperCase())));

		//filter 对Optional的值做判断
		Optional<String> longStr = Optional.of("Long String");
		System.out.println(longStr.filter(s->s.length()>5).get());
		System.out.println(longStr.filter(s -> s.endsWith("g")).get());
		try {
			System.out.println("long kk:"+longStr.filter(s -> s.length()<1));
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}

	}

}
