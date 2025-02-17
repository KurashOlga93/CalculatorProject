package app;

public class Calculator {

    public double sum(double x, double y) {
        System.out.println("Sum of " + x + " and " + y);
        return x + y;
    }

    public double subtract(double x, double y) {
        System.out.println("Subtract of " + x + " and " + y);
        return x - y;
    }

    public double multiply(double x, double y) {
        System.out.println("Multiply of " + x + " and " + y);
        return x * y;
    }

    public double division(double x, double y) {
        System.out.println("Division of " + x + " and " + y);
        if (y == 0) {
            System.out.println("Division by zero is prohibited.");
            return 0;
        }
        return x / y;
    }
}