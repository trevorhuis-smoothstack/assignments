package com.smoothstack.assignments.two.shapes;

public class Rectangle implements Shape{
    Double length;
    Double width;

    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Number calculateArea() {
        return this.length * this.width;
    }

    @Override
    public void display() {
        System.out.printf("%nDimensions of the Rectangle%n");
        System.out.println("Area: " + calculateArea());
        System.out.println("Length: " + this.length);
        System.out.println("Width: " + this.width);

    }

}