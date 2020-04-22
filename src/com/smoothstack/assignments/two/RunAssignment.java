package com.smoothstack.assignments.two;

import com.smoothstack.assignments.two.CommandLineCalculator;
import com.smoothstack.assignments.two.FindMaxInArray;
import com.smoothstack.assignments.two.shapes.*;

public class RunAssignment {

    public static void main(String[] args) {
        CommandLineCalculator question1 = new CommandLineCalculator();
        question1.run();

        FindMaxInArray question2 = new FindMaxInArray();
        question2.run();

        // Question 3
        Triangle triangle = new Triangle(10.4, 5.3);
        Rectangle rectangle = new Rectangle(12.8, 4.0);
        Circle circle = new Circle(7.2);

        triangle.display();
        rectangle.display();
        circle.display();
    }
}