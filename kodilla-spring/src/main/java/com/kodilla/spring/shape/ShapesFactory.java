package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShapesFactory {

    @Bean
    public Square createSquare() {
        return new Square();
    }

    @Bean
    public Shape chosenShape() {
        Shape theChosen;
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        if (randomNum == 0) {
            theChosen = new Triangle();
        } else if (randomNum == 1) {
            theChosen = new Circle();
        } else {
            theChosen = new Square();
        }
        return theChosen;
    }
}
