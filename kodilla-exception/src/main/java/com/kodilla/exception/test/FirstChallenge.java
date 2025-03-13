package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by zero! Error: " + e);
        } finally {
            System.out.println("You are now challenged!");
        }

        int power = power(4, 3);
        System.out.println(power);
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        base = base * power(base, exponent - 1);
        return base;
    }
}