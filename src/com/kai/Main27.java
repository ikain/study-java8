package com.kai;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main27 {
    public static void main(String[] args) {
        System.out.println((String)null);
        List<Integer> list = Arrays.asList(1,2,3,4,5,7);
        Integer minSeq = list.stream().mapToInt(Integer::intValue).min().orElse(-1);
        if (!minSeq.equals(0)) {
            // 审批流节点中最小数必须是0 从0开始
            System.out.println("error1-" + minSeq);
        }
        List<Integer> seqList = list.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < seqList.size(); i++) {
            if (i == seqList.get(i)) {
                System.out.println("ok-" + seqList.get(i));
            } else {
                System.out.println("error2-" + seqList.get(i));
            }
        }
    }
}
