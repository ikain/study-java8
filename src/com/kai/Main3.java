package com.kai;

/**
 * Created by Kai on 2015/7/4.
 */
public interface Main3 {
    void findOne();
    default void select(){

    }
    default void query(){
        System.out.println("query");
    }
}
