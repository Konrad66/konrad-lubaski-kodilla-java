package com.kodilla.stream.lambda.ex2;

public class ExpressionExecutor {

    public void executeExpression(double a, double b, MathExpression mathExpression){
        double result = mathExpression.calculateExpression(a, b);
        System.out.println("Result equals: " + result);
    }
}