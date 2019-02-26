package com.kai;

import java.util.ArrayList;
import java.util.List;

public class Main29 {

    public static void main(String[] args) {
        // 入参
        int page = 1; // 1-n 第几页
        int pageSize = 10; // 1-n 总行数
        // 分页逻辑
        int countTotal = 0;
        // 总集合
        List<Object> itemsAll = new ArrayList<>();
        // sql 1 count
        int pageOneCount = countSql();
        if (pageOneCount > 0) {
            // sql 1 list
            List<Object> pageOne = findPage(page, pageSize, 0);
            itemsAll.addAll(pageOne);
            countTotal = pageOneCount;
        }
        int itemsSize = itemsAll.size();
        // sql 2 count
        int pageTwoCount = countSql();
        if (itemsSize != pageSize) {
            int pageY = 0;
            if (itemsSize == 0) {
                // 计算sql2的 beginIndex - n
                pageY = countTotal % pageSize;
            }
            // 计算sql2的 page
            page = page - (countTotal / pageSize);
            // 计算sql2的 pageSize
            pageSize = pageSize - itemsSize;
            // sql 2 list
            List<Object> pageTwo = findPage(page, pageSize, pageY);
            itemsAll.addAll(pageTwo);

        }
        countTotal += pageTwoCount;

        Page<Object> objectPage = new Page<>(itemsAll, countTotal);

    }

    static List<Object> findPage(int page, int pageSize, int pageY) {
        // sql 1
        List<Object> list = limitSql(page, pageSize, pageY);
        return list;
    }

    static List<Object> limitSql(int page, int pageSize, int pageY) {
        int beginIndex = ((page - 1) * pageSize) - pageY;
        int length = pageSize;
        // return select * from table limit beginIndex,length
        return new ArrayList<>();
    }

    static int countSql() {
        // return select count(1) from table
        return 0;
    }

    static class Page<T> {
        int count;
        List<T> items;
        Page(List<T> items, int count){
            this.count = count;
            this.items = items;
        }
    }
}
