package com.kai.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FengKai on 2018/6/22.
 */
public class FlyweightModel {

    /**
     * 享元模式（Flyweight）
     * 使用共享对象的方法，用来尽可能减少内存使用量。
     * 通常使用工厂类辅助，例子中使用一个HashMap类进行辅助判断，
     * 数据池中是否已经有了目标实例，如果有，则直接返回，不需要多次创建重复实例。
     * @param args
     */
    public static void main(String[] args) {
        ClassObjectFactory factory = new ClassObjectFactory();
        ClassObject langString = factory.getClassObject("java.lang.String");
        ClassObject langInteger = factory.getClassObject("java.lang.Integer");
        factory.getClassObject("java.lang.Integer");
        factory.getClassObject("java.lang.Boolean");
        factory.getClassObject("java.lang.Long");
        factory.getClassObject("java.lang.Long");
        factory.map.forEach((k, v) -> System.out.println("key->" + k + ",value->" + v));
    }

}

class ClassObject {

    private Object object;

    ClassObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ClassObject{" + "object=" + object + '}';
    }
}

class ClassObjectFactory {
    Map<Object, ClassObject> map;

    ClassObjectFactory() {
        map = new HashMap<>();
    }

    ClassObject getClassObject(Object objKey) {
        if (map.containsKey(objKey)) {
            return map.get(objKey);
        } else {
            ClassObject classObject = new ClassObject(objKey);
            map.put(objKey, classObject);
            return classObject;
        }
    }
}