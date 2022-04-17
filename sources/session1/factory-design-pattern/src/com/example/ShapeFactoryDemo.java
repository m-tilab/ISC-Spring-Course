package com.example;

public class ShapeFactoryDemo {

    public static void main(String[] args) {

        //ShapeFactory shapeFactory = new ShapeFactory();
        final Shape shape = ShapeFactory.drawShape("rectangle");

        shape.draw();
    }
}
