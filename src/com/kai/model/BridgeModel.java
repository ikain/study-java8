package com.kai.model;

/**
 * Created by FengKai on 2018/6/25.
 */
public class BridgeModel {
    /**
     * 桥接模式
     * 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。
     * 这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
     * @param args
     */
    public static void main(String[] args) {
        Shape redShape = new Circle(0, 0, 0, new RedCircle());
        Shape greenShape = new Circle(1, 1, 1, new GreenCircle());
        redShape.draw();
        greenShape.draw();
    }
}

interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}

class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}

abstract class Shape {
    DrawAPI drawAPI;

    Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}

class Circle extends Shape {
    private int radius, x, y;

    Circle(int radius, int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}