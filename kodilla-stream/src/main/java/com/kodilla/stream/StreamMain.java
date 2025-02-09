package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ex1.Processor;
import com.kodilla.stream.lambda.ex2.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;


public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));


        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Alphabet", (text) -> "ABC" + text + "ABC");
        poemBeautifier.beautify("Kolejny przykład", (text) -> "<--" + text + "-->");
        poemBeautifier.beautify("Przyklad", (text) -> "***" + text.toUpperCase() + "***");
        poemBeautifier.beautify("Piekny text", (text) -> "<-WoW->" + text.toUpperCase() + "<-Koniec upiększania->");
    }
}