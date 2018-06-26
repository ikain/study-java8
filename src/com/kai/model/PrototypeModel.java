package com.kai.model;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by FengKai on 2018/6/26.
 */
public class PrototypeModel {
    /**
     * 原型模式
     * 是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
     */
    public static void main(String[] args) {
        ShapeCache.loadCache();
        ShapeCache.getShape(1).draw();
        System.out.println("原型拷贝实例："+ShapeCache.getShape(1).toString());
        ShapeCache.getShape(2).draw();
        System.out.println("原型拷贝实例："+ShapeCache.getShape(3).toString());
    }
}

class ShapeCache {
    private static Map<Integer, Shapes> map = new Hashtable<>();

    public static Shapes getShape(int id){
        Shapes shapes = map.get(id);
        return (Shapes) shapes.clone();
    }

    public static void loadCache() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId(1);
        Square square = new Square();
        square.setId(2);
        System.out.println("原始缓存地址："+rectangle.toString());
        System.out.println("原始缓存地址："+square.toString());
        map.put(rectangle.getId(), rectangle);
        map.put(square.getId(), square);
    }
}

abstract class Shapes implements Cloneable {
    private Integer id;
    protected String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    abstract void draw();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Rectangle extends Shapes {
    public Rectangle() {
        super.type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square extends Shapes {
    public Square() {
        super.type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}