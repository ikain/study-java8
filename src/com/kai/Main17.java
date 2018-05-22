package com.kai;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Field;

/**
 * Created by FengKai on 2018/1/5.
 */

/**
 * 自定义注解
 *
 * @author Uno
 * @Documented:指明该注解可以用于生成doc
 * @Inherited：该注解可以被自动继承
 * @Retention:指明在什么级别显示该注解： RetentionPolicy.SOURCE 注解存在于源代码中，编译时会被抛弃
 * RetentionPolicy.CLASS 注解会被编译到class文件中，但是JVM会忽略
 * RetentionPolicy.RUNTIME JVM会读取注解，同时会保存到class文件中
 * @Target:指明该注解可以注解的程序范围 ElementType.TYPE 用于类，接口，枚举但不能是注解
 * ElementType.FIELD 作用于字段，包含枚举值
 * ElementType.METHOD 作用于方法，不包含构造方法
 * ElementType.PARAMETER 作用于方法的参数
 * ElementType.CONSTRUCTOR 作用于构造方法
 * ElementType.LOCAL_VERIABLE 作用于本地变量或者catch语句
 * ElementType.ANNOTATION_TYPE 作用于注解
 * ElementType.PACKAGE 作用于包
 */
public class Main17 {

    @Hint(value = "2")
    private String str = "XX";

    public static void main(String[] args) {
        try {
            Field[] fields = Main17.class.getDeclaredFields();
            fields[0].setAccessible(true);
            System.out.println(fields[0]);
            System.out.println(fields[0].getAnnotation(Hint.class));
            Field strField = Main17.class.getDeclaredField("str");
            //strField.setAccessible(true);
            System.out.println(strField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}