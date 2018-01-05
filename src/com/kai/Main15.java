package com.kai;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FengKai on 2018/1/5.
 * Map API
 */
public class Main15 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val_" + i);
        }

        //获取已存在的key value 拿到 生成newValue
        //V compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        map.compute(9, (k, v) -> k + v + "compute");//R apply(T t, U u);

        //获取key value是否存在，不存在，则Function接口生成newValue
        //V computeIfAbsent(K key,Function<? super K, ? extends V> mappingFunction)
        map.computeIfAbsent(9, k -> k + "computeIfAbsent");//R apply(T t);
        map.computeIfAbsent(10, k -> k + "computeIfAbsent");//R apply(T t);

        //获取key value存在，則key+oldValue生成newValue 替換掉已有的key value
        map.computeIfPresent(8, (k, v) -> k + v + "computeIfPresent");//R apply(T t, U u);
        //获取key value不存在，則key+null+其他
        map.computeIfPresent(11, (k, v) -> k + v + "computeIfPresent");

        System.out.println(map.remove(12));//null
        System.out.println(map.remove(7, "val_7"));//true
        System.out.println(map.remove(12, "val_12"));//必須key value能全部對上才能一處 false

        map.forEach((k, v) -> System.out.println(k + " " + v));

        /*
         V getOrDefault(Object key, V defaultValue) {
            V v;
            return (((v = get(key)) != null) || containsKey(key)) ? v : defaultValue;
         }
         */
        System.out.println(map.getOrDefault(12, "not found 12"));
        System.out.println(map.getOrDefault(1, "not found 1"));

        //如下定義，獲取key的oldValue，接收入參newValue，運算出新值替換oldValue
        System.out.println(map.merge(1, "newValue", (oldValue, newValue) -> newValue.concat(oldValue)));

    }
}
