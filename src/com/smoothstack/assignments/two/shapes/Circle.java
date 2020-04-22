package com.smoothstack.assignments.two.shapes;

import static java.lang.Math.PI;

public class Circle implements Shape {
    Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Number calculateArea() {
        return (this.radius * this.radius) * Math.PI;
    }

    @Override
    public void display() {
        System.out.printf("%nDimensions of the Circle%n");
        System.out.println("Area: " + calculateArea());
        System.out.println("Radius: " + this.radius);
    }

}