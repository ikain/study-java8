package com.kai;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by FengKai on 2018/1/5.
 */
public class Main17 {

    @Hint(value = "")
    private String str;
}


@Target(ElementType.FIELD)
@interface Hint{
    String[] value() default "string";
}