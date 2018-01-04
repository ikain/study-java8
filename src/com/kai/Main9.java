package com.kai;

/**
 * Created by FengKai on 2018/1/3.
 */
public class Main9 {

    static int sm = 2;

    final static int sn = 2;

    int lm = 2;

    public static void main(String[] args) {
        //自定义支持lambda的接口 并实现
        Converter<String, Integer> converter = from -> String.valueOf(from);
        System.out.println(converter.convert(123));
        converter = Object::toString;
        System.out.println(converter.convert(134));

        Converter<Integer, String> converter1 = from -> Integer.valueOf(from);//语法1
        converter1 = (from) -> {
            return Integer.valueOf(from);
        }; //语法2

        System.out.println(converter1.convert("111"));

        SomeThing someThing = new SomeThing();
        Converter<String, String> converter2 = SomeThing::upperCase;//类::静态方法
        System.out.println(converter2.convert("jAvA"));
        Converter<String, String> converter3 = someThing::lowerCase;//对象::实例方法
        System.out.println(converter3.convert("JAVA"));

        Converter<String, String> converter4 = String::toLowerCase;


        //可以用lambda访问外部的final局部变量 static
        int m =2;
        final int mn = 2;
        //就算m没有用final修复，在编译时候，也会隐式用final修饰，所以出现在lambda中的变量 不能被修改
        Converter<Integer,Integer> converter5 = from -> from+m+sn+sm+mn;


    }
}

@FunctionalInterface
interface Converter<T, F> {
    T convert(F from);
}

class SomeThing {
    static String upperCase(String s) {
        return s.toUpperCase();
    }

    String lowerCase(String s) {
        return s.toLowerCase();
    }
}