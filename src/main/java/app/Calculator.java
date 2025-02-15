package app;

import org.openqa.selenium.By;

public class Calculator {

    public double sum(double x, double y) {
        return x + y;
    }

    public double subtract(double x, double y) {
        return x - y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }

    public double division(double x, double y) {
        if (y == 0) {
            System.out.println("Division by zero is prohibited.");
            return 0;
        }
        return x / y;
    }
}