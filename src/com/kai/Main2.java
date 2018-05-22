package com.kai;

import java.util.Optional;

/**
 * Created by Kai on 2015/7/4.
 */
public class Main2 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Optional<String> name = Optional.empty();
        name.ifPresent(System.out::println);
    }
}
