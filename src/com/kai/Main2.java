package com.kai;

import java.util.Optional;

/**
 * Created by Kai on 2015/7/4.
 */
public class Main2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Optional<String> name = Optional.empty();
        name.ifPresent(System.out::println);

        System.out.println(splitString("1516654648894"));

        int[] oldArray = new int[]{4, 6, 5, 7, 4, 8, 4, 9, 2, 3, 4, 2};
        int[] newArrayAsc = sort(oldArray, true);
        // 正序
        for (int aNewArray : newArrayAsc) {
            System.out.print(aNewArray + ",");
        }
        int[] newArrayDesc = sort(oldArray, false);
        System.out.println();
        for (int aNewArray : newArrayDesc) {
            System.out.print(aNewArray + ",");
        }
        // 倒序
    }

    private static int[] sort(int[] arrayInt, boolean isAsc) {
        int temp;
        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = i + 1; j < arrayInt.length; j++) {
                // isAsc = true 为正序
                if (isAsc && arrayInt[i] > arrayInt[j]) {
                    temp = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = temp;
                }
                // isAsc = false 为倒序
                if (!isAsc && arrayInt[i] < arrayInt[j]) {
                    temp = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = temp;
                }
            }
        }
        return arrayInt;
    }


    private static String splitString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i)).append(",");
        }
        return stringBuilder.toString();
    }
}
