package com.kai;

import java.util.Optional;

public class Main28 {
    public static void main(String[] args) {
        Double theory = null;
        Double operate = null;
        int sumScore = (int) (((theory == null ? 0 : theory) + (operate == null ? 0 : operate)) * 100);
        System.out.println(sumScore);

        Optional.empty().map(k -> {
            System.out.println("k" + k);
            return k;
        });
        Optional.of("k").map(k -> {
            System.out.println("k" + k);
            return k;
        });
    }
}
