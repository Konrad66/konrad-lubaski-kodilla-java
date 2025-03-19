package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;

public class MovieRunner {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movies = movieStore.getMovies();
        movieStore.printMovies(movies);
        movieStore.factorial(5);
    }
}