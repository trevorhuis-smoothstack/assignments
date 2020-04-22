package com.smoothstack.assignments.two.shapes;

public class Triangle implements Shape{
    Double base;
    Double height;

    public Triangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Number calculateArea() {
        return (this.base * this.height) * 0.5;
    }

    @Override
    public void display() {
        System.out.printf("%nDimensions of the Triangle%n");
        System.out.println("Area: " + calculateArea());
        System.out.println("Base: " + this.base);
        System.out.println("Height: " + this.height);
    }


}